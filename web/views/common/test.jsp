<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table style="WIDTH: 100%">
<tbody>
<tr>
<td style="width:120px;text-align:right;">주소로 좌표찾기 : </td>
<td style="width:350px;"><input id="tx01" name="tx01" style="width:340px;border: 1px solid #C3C3C3;outline-width:0px;"></td>
<td style="width:70px;"><input id="bAddress" type="button" value="  상세주소  " onclick="NewZipCode5NumCheck(); return false;"></td>
<td style="width:70px;"><input id="bSearch" type="button" value="  좌표조회  "></td><td></td></tr></tbody></table>
<div id="map" style="HEIGHT: 400px; WIDTH: 100%"></div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=32a364f56c1e2fe3c30aa773daa80f7e&libraries=services"></script>
<script id="code">
    var mapOptions = {
        center: new naver.maps.LatLng(36.0190238, 129.3433917),
        zoom: 10,
        scaleControl: false,
        logoControl: false,
        mapDataControl: false,
        mapTypeControl: true,
        zoomControl: true,
        minZoom: 1
    };
    
    var map = new naver.maps.Map('map', mapOptions);
    
    var marker = new naver.maps.Marker({
        position: new naver.maps.LatLng(36.0190238, 129.3433917),
        map: map
    });

    var infoWindow = new naver.maps.InfoWindow({
        content: ''
    });
    
    updateInfoWindow(map.getCenter());
    
    map.addListener('click', function(e) {
        updateInfoWindow(e.coord);
    });

    map.addListener('idle', function(e) {
        //updateInfoWindow(map.getCenter());
    });
    
    function updateInfoWindow(latlng) {
        var utmk       = naver.maps.TransCoord.fromLatLngToUTMK(latlng),    // 위/경도 -> UTMK
            tm128      = naver.maps.TransCoord.fromUTMKToTM128(utmk),       // UTMK    -> TM128
            naverCoord = naver.maps.TransCoord.fromTM128ToNaver(tm128),     // TM128   -> NAVER
            latlngConv = naver.maps.LatLng(latlng);                         // 위/경도
        
        var latVal = latlngConv.lat();
            lngVal = latlngConv.lng();
            
        utmk.x = parseFloat(utmk.x.toFixed(1));
        utmk.y = parseFloat(utmk.y.toFixed(1));
        
        infoWindow.setContent([
            '<div style="padding:10px;width:340px;font-size:14px;line-height:20px;">',
            '<span onclick="selectLatLng('+latVal+', '+lngVal+');" style="cursor:pointer;"><strong>LatLng</strong> : '+ latlngConv +'</span> (◀ 클릭)<br />',
            '<strong>UTMK  </strong> : '+ utmk       +'<br />',
            '<strong>TM128 </strong> : '+ tm128      +'<br />',
            '<strong>NAVER </strong> : '+ naverCoord +'<br />',
            '</div>'
        ].join(''));
        
        infoWindow.open(map, latlng);
    }

    function selectLatLng(lat, lng) {
        var sHTMLCODE = "";
            sHTMLCODE = sHTMLCODE + "&lt;script type=&quot;text/javascript&quot; src=&quot;https://openapi.map.naver.com/openapi/v3/maps.js?clientId=본인ClientId&quot;&gt;&lt;/script&gt;</br>";
            sHTMLCODE = sHTMLCODE + "&lt;div style=&quot;WIDTH:100%;height:400px;&quot; id=&quot;map&quot;&gt;&lt;/div&gt;                                                                </br>";
            sHTMLCODE = sHTMLCODE + "&lt;script&gt;                                                                                                                                       </br>";
            sHTMLCODE = sHTMLCODE + "&nbsp;&nbsp;&nbsp;&nbsp;var position = new naver.maps.LatLng("+lat+", "+lng+");                                                                       </br>";
            sHTMLCODE = sHTMLCODE + "&nbsp;&nbsp;&nbsp;&nbsp;var mapOptions = {                                                                                                           </br>";
            sHTMLCODE = sHTMLCODE + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;center: position ,                                                           </br>";
            sHTMLCODE = sHTMLCODE + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;zoom: 10,                                                                    </br>";
            sHTMLCODE = sHTMLCODE + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;scaleControl: false,                                                         </br>";
            sHTMLCODE = sHTMLCODE + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;logoControl: false,                                                          </br>";
            sHTMLCODE = sHTMLCODE + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mapDataControl: false,                                                       </br>";
            sHTMLCODE = sHTMLCODE + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mapTypeControl: true,                                                        </br>";
            sHTMLCODE = sHTMLCODE + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;zoomControl: true,                                                           </br>";
            sHTMLCODE = sHTMLCODE + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;minZoom: 1                                                                   </br>";
            sHTMLCODE = sHTMLCODE + "&nbsp;&nbsp;&nbsp;&nbsp;};                                                                                                                           </br>";
            sHTMLCODE = sHTMLCODE + "&nbsp;&nbsp;&nbsp;&nbsp;var map = new naver.maps.Map(&quot;map&quot;, mapOptions);                                                                   </br>";
            sHTMLCODE = sHTMLCODE + "&nbsp;&nbsp;&nbsp;&nbsp;var marker = new naver.maps.Marker({                                                                                         </br>";
            sHTMLCODE = sHTMLCODE + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;position: position,                                                                                  </br>";
            sHTMLCODE = sHTMLCODE + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;map: map                                                                                             </br>";
            sHTMLCODE = sHTMLCODE + "&nbsp;&nbsp;&nbsp;&nbsp;});                                                                                                                          </br>";
            sHTMLCODE = sHTMLCODE + "&lt;/script&gt;                                                                                                                                      </br>";
        $("#scriptCode").html("");
        $("#scriptCode").html(sHTMLCODE);
    }

    function selectAddress(lat, lng) {
        var latlng = new naver.maps.LatLng(lat, lng);
        map.setCenter(latlng);          // 중심 좌표 이동
        //map.setZoom(13);              // 줌 레벨 변경
        marker.setPosition(latlng);     // 마크 이동
        updateInfoWindow(latlng);       // 정보창 표현
        $("#bAddress").focus();
        $("#addrList").css("visibility", "hidden");
    }

    $("#bSearch").click( function () {
        var sHTML = "";
        var sUrl  = "https://apis.daum.net/local/geo/addr2coord?apikey=69ffffbddf73b860047324d8b4663084&output=json&page_size=30&q=";
        var sAddr = $("#tx01").val();
        if ( sAddr.length == 0 )
        {
            alert("주소를 입력하세요");
            $("#bAddress").focus();
            return;
        }
        $.ajax({
            type: "post",
            url: sUrl + encodeURIComponent(sAddr),
            dataType: "jsonp",
            async:true,
            success: function (data){
                if ( data.channel.item.length == 0 )
                {
                    alert("올바른 주소를 입력하세요");
                    $("#bAddress").focus();
                }
                else if ( data.channel.item.length == 1 )
                {
                    selectAddress(data.channel.item[0].lat, data.channel.item[0].lng);
                }
                else
                {
                    sHTML = sHTML + "<table cellpadding=\"5\" cellspacing=\"5\" width=\"100%\" height=\"100%\">                                                      ";
                    sHTML = sHTML + "<tbody>                                                                                                                         ";
                    sHTML = sHTML + "<tr>                                                                                                                            ";
                    sHTML = sHTML + "    <td align=\"center\" valign=\"middle\" style=\"background-color:#FFFFFF;\">                                                 ";
        			sHTML = sHTML + "	<table cellpadding=\"3\" cellspacing=\"3\" style=\"border:2px solid #c5dbec;\" width=\"100%\">                               ";
        			sHTML = sHTML + "	<tbody>                                                                                                                      ";
        			sHTML = sHTML + "	<tr>                                                                                                                         ";
            		sHTML = sHTML + "		<td style=\"border:1px solid #c5dbec;text-align:center;height:30px;font-weight:bold;background-color:#dfeffc;\">주소</td>";
            		sHTML = sHTML + "		<td style=\"border:1px solid #c5dbec;text-align:center;height:30px;font-weight:bold;background-color:#dfeffc;\">lat</td> ";
            		sHTML = sHTML + "		<td style=\"border:1px solid #c5dbec;text-align:center;height:30px;font-weight:bold;background-color:#dfeffc;\">lng</td> ";
        			sHTML = sHTML + "	</tr>                                                                                                                        ";
        			for (var i = 0; i < data.channel.item.length; i++) 
        			{
        				sHTML = sHTML + "<tr>                                                                                                                                                                                                                                                                       ";
            			sHTML = sHTML + "	<td style=\"border:1px solid #c5dbec;text-align:left;height:30px;font-weight:bold;background-color:#f9fcff;cursor:pointer;\" onclick=\"selectAddress('"+data.channel.item[i]["lat"]+"', '"+data.channel.item[i]["lng"]+"');\">" + data.channel.item[i]["title"] + "</td>";
            			sHTML = sHTML + "	<td style=\"border:1px solid #c5dbec;text-align:center;height:30px;background-color:#ffffff;\">" + data.channel.item[i]["lat"] + "</td>                                                                                                                                 ";
            			sHTML = sHTML + "	<td style=\"border:1px solid #c5dbec;text-align:center;height:30px;background-color:#ffffff;\">" + data.channel.item[i]["lng"] + "</td>                                                                                                                                 ";
        				sHTML = sHTML + "</tr>                                                                                                                                                                                                                                                                      ";
        			}
                    sHTML = sHTML + "</tbody></table></td></tr></tbody></table>";
                    $("#addrList").html("");
                    $("#addrList").html(sHTML);
                    $("#bAddress").focus();
                    $("#addrList").css("visibility", "visible");
                }
            },  
            error: function ( jqXHR, textStatus, errorThrown ) {
                alert( '[' + jqXHR.status + '] ' + textStatus + ': ' + errorThrown + ': ' + jqXHR.responseText );
            }
        });
    });
    
    $("body").append("<div id=\"addrList\" style=\"visibility:hidden;position:absolute;top:25%;left:25%;width:50%;height:50%;z-index:99999;border-width:1px;border-style:none;\"></div>");
</script>

</body>
</html>