## Together_애견 동반 호텔 예약 사이트

---------------------------------------
## 개발환경
>Front End
* HTML
* CSS
* JAVASCRIPT
>Back End
* MyBatis
* Sprint Framework
* Java(JDK1.8)
* Maven
>Database
* HeidiSQL
* MariaDB
---------------------------------------
## QNA 게시판 LIST 관련 Back-End 주요기능
1. BoardController (QNA관련)
```
@Controller
public class BoardController {

   @Autowired
   private SqlSession sqlSession;
   private Command command;

   //QNA

   @RequestMapping(value="qnaBoardList", method=RequestMethod.GET)
   public String qnaBoardList(HttpServletRequest request, Model model) {
      model.addAttribute("request", request);
      command = new QNABoardListCommand();
      command.execute(sqlSession, model);
      return "qnaBoard/qnaBoardListPage";
   }
   
   @RequestMapping("qnaBoardView")
   public String qnaBoardView(HttpServletRequest request, Model model) {
      model.addAttribute("request", request);
      command = new QNABoardViewCommand();
      command.execute(sqlSession, model);
      return "qnaBoard/qnaBoardViewPage";
   }
   
   @RequestMapping("qnaBoardUpdatePage")
   public String qnaBoardUpdatePage(HttpServletRequest request, Model model) {
      model.addAttribute("request", request);
      command = new QNABoardViewCommand();
      command.execute(sqlSession, model);
      return "qnaBoard/qnaBoardUpdatePage";
   }
   
   @RequestMapping(value="qnaBoardUpdate", method=RequestMethod.POST)
   public String qnaBoardUpdate(HttpServletRequest request, Model model) {
      model.addAttribute("request", request);
      command = new QNABoardUpdateCommand();
      command.execute(sqlSession, model);
      return "redirect:qnaBoardView";
   }
   
   @RequestMapping(value="qnaBoardDelete", method=RequestMethod.POST)
   public String qnaBoardDelete(HttpServletRequest request, Model model) {
      model.addAttribute("request", request);
      command = new QNABoardDeleteCommand();
      command.execute(sqlSession, model);
      return "redirect:qnaBoardList";
   }
   
   @RequestMapping("qnaBoardInsertPage")
   public String qnaBoardInsertPage() {
      return "qnaBoard/qnaBoardInsertPage";
   }
   
   @RequestMapping(value="qnaBoardInsert1", method=RequestMethod.POST)
   public String qnaBoardInsert1(HttpServletRequest request, Model model) {
      model.addAttribute("request", request);
      command = new QNABoardInsertCommand1();
      command.execute(sqlSession, model);
      return "redirect:qnaBoardList";
   }
   
   @RequestMapping(value="qnaBoardInsert2", method=RequestMethod.POST)
   public String qnaBoardInsert2(HttpServletRequest request, Model model) {
      model.addAttribute("request", request);
      command = new QNABoardInsertCommand2();
      command.execute(sqlSession, model);
      return "redirect:qnaBoardList";
   }
   
   @RequestMapping(value="qnaBoardReplyInsert", method=RequestMethod.POST)
   public String qnaBoardReplyInsert(HttpServletRequest request, Model model) {
      model.addAttribute("request", request);
      int qNo = Integer.parseInt(request.getParameter("qNo"));
      command = new QNABoardReplyInsertCommand();
      command.execute(sqlSession, model);
      return "redirect:qnaBoardView?qNo="+qNo;
   }
   
   @RequestMapping(value="qnaBoardReplyDelete", method=RequestMethod.POST)
   public String qnaBoardReplyDelete(HttpServletRequest request, Model model) {
      model.addAttribute("request", request);
      int qNo = Integer.parseInt(request.getParameter("qNo"));
      command = new QNABoardReplyDeleteCommand();
      command.execute(sqlSession, model);
      return "redirect:qnaBoardView?qNo="+qNo;
   }
   
   @RequestMapping(value="qnaBoardReplyUpdate", method=RequestMethod.POST)
   public String qnaBoardReplyUpdate(HttpServletRequest request, Model model) {
      model.addAttribute("request", request);
      int qNo = Integer.parseInt(request.getParameter("qNo"));
      command = new QNABoardReplyUpdateCommand();
      command.execute(sqlSession, model);
      return "redirect:qnaBoardView?qNo="+qNo;
   }
```
2. QNABoardListCommand.java
```
public class QNABoardListCommand implements Command {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> mMap = model.asMap();
		HttpServletRequest request = (HttpServletRequest) mMap.get("request");
		//페이지 이동에서 데이터 쓰기 편한 형태로 변환 
		
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		//HttpServletRequest형태의 page를 int형으로 바꾸기 위함.
		
		int recordPerPage = 5;
		int beginRecord2 = (page-1) * recordPerPage ;//0//5
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("beginRecord2", beginRecord2);

		
		SevenFactoryDAO qDAO = sqlSession.getMapper(SevenFactoryDAO.class);
		
		ArrayList<QNADTO> list = qDAO.selectQNABoard(map);
		int totalRecord = qDAO.getTotalRecord();
		String pageView = PageMaker.getPageView("qnaBoardList", page, recordPerPage, totalRecord);  
		
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("pageView", pageView);
		model.addAttribute("totalRecord", totalRecord);

	}

}
```
3. 페이징 처리
```
package com.koreait.sevenfactory.common;

public class PageMaker {
	//qna  관련
	public static String getPageView(String path, int page, int recordPerPage, int totalRecord) {
		
		StringBuffer sb = new StringBuffer();
		
		int totalPage = 1;
		int pagePerBlock = 5;
		int beginPageOfBlock = 0;
		int endPageOfBlock = 0;
		
		totalPage = (int)(totalRecord / recordPerPage);//-->2
		if ( totalRecord % recordPerPage != 0 ) {
			totalPage++; //-->3
		}
		//totalrecord인 게시글 전체 갯수가 내가 설정한 페이지하나당 들어갈수있는 게시글의 갯수보다 많으면 페이지추가
	
		beginPageOfBlock = (int)(((page - 1) / pagePerBlock) * pagePerBlock) + 1;
		//1  beginRecord
		endPageOfBlock = beginPageOfBlock + pagePerBlock - 1;
		//5 endRecord
		
		if ( endPageOfBlock > totalPage ) {
			endPageOfBlock = totalPage;
			//위에서 계산한 totalPage를 endPageOfBlock에 넣어주기 위함
		}
		//endPageofBlock=3 beginPageOfBlock = 1  endRecord=5  pagePerBlock=5  page=1설정완료
		
		
		// 이전 버튼 표시
		if ( beginPageOfBlock < pagePerBlock ) {
			sb.append("<span style='color: lightgray;'>◀</span>&nbsp;&nbsp;");
			//버튼표시
		} else {
			sb.append("<a href='" + path + "?page=" + (beginPageOfBlock - 1) + "'>◀</a>&nbsp;&nbsp;");
		}
		
		// 페이지 번호 표시
		for ( int p = beginPageOfBlock; p <= endPageOfBlock; p++ ) {
			if ( p == page ) {
				sb.append("<span style='color: lightgray;'>" + p + "</span>&nbsp;&nbsp;");
				//html에 번호 추가   1~3
			} else {
				sb.append("<a href='" + path + "?page=" + p + "'>" + p + "</a>&nbsp;&nbsp;");
		
			}
		}
		
		
		// 다음 버튼 표시
		if(endPageOfBlock < 5){
			sb.append("<span style='color: lightgray;'>▶</span>");
			} else {
			if (totalPage%5 == 1 && endPageOfBlock %5 == 1){
			sb.append("<span style='color: lightgray;'>▶</span>");
			} else {
			if (totalPage <= endPageOfBlock){
			sb.append("<span style='color: lightgray;'>▶</span>");
			}else {
			if(totalPage%5 == 1 && endPageOfBlock%5 ==0){
				sb.append("<a href='" + path + "?page=" + (endPageOfBlock + 1) + "'>▶</a>&nbsp;&nbsp;");
			}else {
			sb.append("<a href='" + path + "?page=" + (endPageOfBlock + 1) + "'>▶</a>&nbsp;&nbsp;");
			}}}}

		return sb.toString();
		
	}

}

```
![p_qna](https://user-images.githubusercontent.com/109268926/201028102-43075927-41c2-41b9-8200-89b956f687c9.PNG)
4. QNA REPLY INSERT 관련 
* CONTROLLER
```
@RequestMapping(value="qnaBoardReplyInsert", method=RequestMethod.POST)
   public String qnaBoardReplyInsert(HttpServletRequest request, Model model) {
      model.addAttribute("request", request);
      int qNo = Integer.parseInt(request.getParameter("qNo"));
      command = new QNABoardReplyInsertCommand();
      command.execute(sqlSession, model);
      return "redirect:qnaBoardView?qNo="+qNo;
   }
```
* QNABoardReplyInsertCommand.java
```
public class QNABoardReplyInsertCommand implements Command {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int qNo = Integer.parseInt(request.getParameter("qNo"));
		String mId = request.getParameter("mId");
		String reContent = request.getParameter("reContent");
		
		SevenFactoryDAO reDAO = sqlSession.getMapper(SevenFactoryDAO.class);
		reDAO.insertQNABoardReply(mId, reContent, qNo);
		
	}
}
```
* 댓글달기 QUERY
```
<insert id="insertQNABoardReply">
		INSERT INTO REPLY (RENO, MID, RECONTENT, QNO, RNO, RECATEGORY, RENOTICEDATE)
		VALUES ((SELECT IFNULL(MAX(reNo) + 1, 1) FROM REPLY AS r), #{param1},
		#{param2}, #{param3}, null, 1, CURRENT_TIMESTAMP())
</insert>
```
![image](https://user-images.githubusercontent.com/109268926/201029309-9cb0ac0e-ca05-478a-b436-55cd9e466ae7.png)

---------------------------------------
## 예약관련 Front-End 주요기능
1. 카카오 지도 API 활용해 호텔 주소와 주변 맛집 위치 마커 
```
          // 이미지 지도에 표시할 마커입니다
          // 이미지 지도에 표시할 마커를 아래와 같이 배열로 넣어주면 여러개의 마커를 표시할 수 있습니다 
          var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
          mapOption = { 
                  center: new kakao.maps.LatLng(36.349268551597966 , 127.37767658950676), // 지도의 중심좌표
                  level: 7// 지도의 확대 레벨
              };

          var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
          var imageSrc = 'https://ifh.cc/g/Gvw26t.png', // 마커이미지의 주소입니다
          //var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_red.png', // 마커이미지의 주소입니다    
           imageSize = new kakao.maps.Size(30, 30), // 마커이미지의 크기입니다
           //imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
           imageOption = {offset: new kakao.maps.Point(10, 10)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.


          // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
          var mapTypeControl = new kakao.maps.MapTypeControl();

          // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
          // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
          map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

          // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
          var zoomControl = new kakao.maps.ZoomControl();
          map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

          //주소를 통한 마커 
          var geocoder = new kakao.maps.services.Geocoder();
          //주소 변수설정 
          var hAddress =  document.getElementById("hAddress").value;
          var haroundfood = hAddress.substr(3,4);
          console.log("hAddress::"+hAddress);
          console.log("haroundfood::"+haroundfood);
          // 주소로 좌표를 검색합니다
          geocoder.addressSearch(hAddress, function(result, status) {
      
          // 정상적으로 검색이 완료됐으면 
           if (status === kakao.maps.services.Status.OK) {

              var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

              // 결과값으로 받은 위치를 마커로 표시합니다
              var marker = new kakao.maps.Marker({
                  map: map,
                  position: coords
              });

              // 인포윈도우로 장소에 대한 설명을 표시합니다
              var infowindow = new kakao.maps.InfoWindow({
                  content: '<div style="width:150px;text-align:center;padding:2px;">호텔위치</div>'
              });
              infowindow.open(map, marker);

              // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
             map.setCenter(coords); 
              
          } 
          });    
      
      

        //숙소 주변 맛집
        // 마커를 클릭하면 장소명을 표출할 인포윈도우 입니다
        var infowindow = new kakao.maps.InfoWindow({zIndex:1});


        // 장소 검색 객체를 생성합니다
        var ps = new kakao.maps.services.Places(); 

        // 키워드로 장소를 검색합니다
        ps.keywordSearch(haroundfood+'맛집', placesSearchCB); 

        // 키워드 검색 완료 시 호출되는 콜백함수 입니다
        function placesSearchCB (data, status, pagination) {
            if (status === kakao.maps.services.Status.OK) {

                // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
                // LatLngBounds 객체에 좌표를 추가합니다
                var bounds = new kakao.maps.LatLngBounds();

                for (var i=0; i<data.length; i++) {
                    displayMarker(data[i]);    
                    bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
                }       

            } 
        }

        // 지도에 마커를 표시하는 함수입니다
        function displayMarker(place) {
            // 마커를 생성하고 지도에 표시합니다
            var marker = new kakao.maps.Marker({
                map: map,
                position: new kakao.maps.LatLng(place.y, place.x) 
            });
            marker.setRange(100);

            // 마커에 클릭이벤트를 등록합니다
            kakao.maps.event.addListener(marker, 'click', function() {
                // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
                infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
                infowindow.open(map, marker);
            });
        }
```
      
![p_reservation2](https://user-images.githubusercontent.com/109268926/201022820-58f0cad8-fe8b-4fe4-81ef-1fb9167e6ee8.PNG)

2. 객실 최대 수용인원에 따른 추가금액 산정
```
	   function fn_change(){
	         selectItem = $("#selectPeople").val();
	         //2+4
	         //4
	         var standardPeople = 2;
	         var condition = selectItem - standardPeople;
	          //4-2=2
	         if(condition == 0){
	            addPrice = 0;
	         }else if(condition == 1){
	            addPrice = 20000;
	         }else if(condition ==2){
	            addPrice =40000;
	         }else{
	            addPrice = 0;
	         }
	         totalPrice = basicPrice + addPrice;
	         $('#addPrice').html("+"+addPrice + "원");
	         if(mName.equals("")){
	        	 $('#totalPrice').html(totalPrice + "원");
	             $('#totalPrice').css('fontWeight','bold').css('color','red');
	             document.getElementById('rPrice').value = totalPrice;
	         }
	         
	      }
	  
        window.addEventListener('keyup', function(event) {
          var point = document.getElementById("use_point").value;
          totalPrice = basicPrice + addPrice - point;
          $('#totalPrice').html(totalPrice + "원");
           $('#totalPrice').css('fontWeight','bold').css('color','red');
           document.getElementById('rPrice').value = totalPrice;
       });
```
* 객실별 최대 수용인원에 따른 option 변경
```
    <select id="selectPeople" name="rPeople" onchange="fn_change()">
                        <option >::인원선택::</option>
                        <option value="1">1</option>
                         <c:if test="${gDTO.gMaxPeople eq 2}">
                         <option value="2">2</option> 
                         </c:if>
                         <c:if test="${gDTO.gMaxPeople eq 3}">
                         <option value="2">2</option> 
                         <option value="3">3</option> 
                         </c:if>
                        <c:if test="${gDTO.gMaxPeople eq 4}">
                        <option value="2">2</option> 
                         <option value="3">3</option> 
                        <option value="4">4</option> 
                        </c:if>
      </select>
```

3. 카카오 결제 API를 활용한 결제 구현 
* 회원
```
 if($("#selectPeople"+${gDTO.gNo}).val() == ''){
            alert('인원을 선택해주세요.');
            return;
         }else if ($("#use_point").val()>point){
            alert('사용가능한 포인트를 확인해주세요');
            document.getElementById("use_point").focus();
         }else{
            IMP.init('imp81561510');
             IMP.request_pay({
                pg:"kakaopay.TC0ONETIME",
                pay_method:"card",
                merchant_uid:"iamport_test_together" + new Date().getTime(),
                name:gName,
                amount: totalPrice,
                buy_email:mEmail,
                buy_name: mName,
                buy_tel :mPhone,
                   }, async function(rsp){
                   if(rsp.success){ 
                      console.log(rsp);
                      console.log(mNo);
                       var sendData = "gNo="+gNo+"&gName="+gName+"&rCheckIn="+rCheckIn+"&rCheckOut="+rCheckOut+"&mNo="+mNo+"&rPeople="
                       +selectItem+"&rPrice="+totalPrice+"&hNo="+hNo+"&point="+point;
                      console.log(rCheckIn);
                       $.ajax({
                             url: "http://localhost:8080/sevenfactory/kakaopay1", // 예: https://www.myservice.com/payments/complete
                               method: "POST",
                               data: sendData,
                               success :function(rsp){
                                  console.log("성공");
                               }
                           }).done(function (data) {
                             // 가맹점 서버 결제 API 성공시 로직
                              alert("결제가 완료되었습니다. 예약확인 페이지로 이동합니다.");
                              window.location = 'http://localhost:8080/sevenfactory/MyReservation?mNo='+mNo;
                           });
                   }else{
                      alert("메시지("+rsp.error_msg+")");
                   }
             });
        }
```
* 비회원
```
 function fn_kakaopay2(f){
      var gNo ='${gDTO.gNo}';
      var rCheckIn ='${rCheckIn }';
      var rCheckOut ='${rCheckOut }';
      var hNo ='${gDTO.hNo}';
      if($("#selectPeople"+${gDTO.gNo}).val() == ''){
            alert('인원을 선택해주세요.');
            return;
         }else{
            IMP.init('imp81561510');
             IMP.request_pay({
                pg:"kakaopay.TC0ONETIME",
                pay_method:"card",
                merchant_uid:"iamport_test_together" + new Date().getTime(),
                name:gName,
                amount: totalPrice,
                buy_name: nmName,
                   }, async function(rsp){
                   if(rsp.success){ 
                      console.log(rsp);
                      console.log(hNo);
                       var sendData = "gNo="+gNo+"&gName="+gName+"&rCheckIn="+rCheckIn+"&rCheckOut="+rCheckOut+"&rPeople="
                       +selectItem+"&rPrice="+totalPrice+"&hNo="+hNo+"+&nmPhone="+nmPhone+"&nmName="+nmName;
                      console.log(nmPhone);
                      console.log(nmName);
                       $.ajax({
                             url: "http://localhost:8080/sevenfactory/kakaopay2", 
                               method: "POST",
                               data: sendData,
                               success :function(rsp){
                                  console.log("성공");
                               }
                           }).done(function (data) {
                             // 가맹점 서버 결제 API 성공시 로직
                              alert("결제가 완료되었습니다. 예약확인 페이지로 이동합니다.");
                              window.location = 'http://localhost:8080/sevenfactory/findReservationNumber'; 
                           });
                   }else{
                      alert("메시지("+rsp.error_msg+")");
                   }
             });
        }
   }
```

![image](https://user-images.githubusercontent.com/109268926/201024464-5a397436-dd47-4ec2-94ca-2c05280e9fe7.png)
---------------------------------------
## API
* NaverAPI
* KakaoAPI
* Daum API
* 국세청 API
---------------------------------------
#### 첫 프로젝트라 아쉬운 점이 많지만 이를 계기로 사용자 편의성을 더 고려하는 개발자가 되겠습니다.
---------------------------------------
