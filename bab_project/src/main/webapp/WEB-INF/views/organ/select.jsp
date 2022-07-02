<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <!-- jsTree js -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/jstree.min.js"></script>
   	<!-- jsTree css -->
<meta charset="UTF-8">
<!-- <title>조직도 조회</title> -->
<style>
        #s_organ_table tr th {
            width: 100px;
            padding: 5px 0;
            font-size: 1.1em;
        }

        #s_organ_table {
            margin-top: 50px;
        }

        #s_organ_table tr button {
            margin-left: 10px;
            font-size: 0.9em;
        }

        #s_organ_table .s_organ_td {
            width: 200px;
        }
    </style>
</head>
<body>

	<c:forEach items="${selectOrganList }" var="i">
		<div class="emp_name" style="display: none;">
			${i.emp_name }
		</div>
		<div class="dept_name_or" style="display: none;">
			${i.dept_name }
		</div>
		<div class="job_title_or" style="display: none;">
			${i.job_title }
		</div>
	</c:forEach>
	<c:forEach items="${selectDeptList }" var="i">
		<div class="dept_code" style="display: none;">
			${i.dept_code }
		</div>
		<div class="dept_name" style="display: none;">
			${i.dept_name }
		</div>
	</c:forEach>
	<c:forEach items="${selectJobList }" var="i">
		<div class="job_title" style="display: none;">
			${i.job_title }
		</div>
	</c:forEach>

	<div style="border: 1px solid lightgray;height: 1000px;width: 1300px;margin-top: 20px;margin-left: 10px;border-radius: 10px;padding: 20px;" >
        <div style="float:left;border: 1px solid lightgray;width: 40%;height: 955px;padding: 20px;border-radius: 10px;overflow: auto;">
            <!-- 검색 -->
            <nav class="navbar navbar-light" style="float: right; margin-bottom: 20px; width: 150px;">
                <div class="container-fluid">
                    <input class="form-control me-2" placeholder="Search" aria-label="Search" id="search" value="" style=" width: 150px;">
                </div>
            </nav>
            
            <!-- 조직도 -->
            <div id="tree" style="float: left;margin-top: 20px;"></div>
        </div>

        <div style="float:left;border-top: 2px solid grey;border-bottom: 2px solid grey;margin-left: 20px;padding: 30px;width: 57%;height: 950px;" id="s_dt_info_content">
            <div style="color: grey;text-align: center;line-height: 800px;">조직도에서 사원을 선택하시면 상세조회가 가능합니다.</div>
        </div>
    </div>

    <script>
        // load가 됐을 때 DB 다녀오기
        $(function() {
			let json = new Array();
			// 최상위부모
			json.push({
		            "id": "1",
		            "parent": "#",
		            "text": "BAB",
		            "icon": "https://www.jstree.com/static/3.2.1/assets/images/tree_icon.png" //root 아이콘 지정
				},
            );
			// 부서 호출
            $.ajax({
            	url: '<%=request.getContextPath()%>/organ/selectdept'
          		, type: 'post'
          		, dataType: 'json'
          		, success: function(result) {
          			for(var i = 0; i < result.length; i++) {
          				json.push({
          					"id": result[i].dept_code,
          					"parent": "1",
          					"text": result[i].dept_name
         					})
          			}
          		}
            });
			// 배열+객체 형태로 받아온 값을 배열만 벗기기
            json.flat();
            
            // 사원 호출
        	$.ajax({
        		url: '<%=request.getContextPath()%>/organ/select'
        		, type: 'post'
        		, dataType: 'json'
        		, success: function(result) {
      					// 사원 정보
	        			for(var i = 0; i<result.length; i++){
	        				json.push({
        			            "id": result[i].emp_no,
        			            "parent": result[i].dept_code,
        			            // emp_no를 띄운 이유 : 상세 조회 시 emp_no를 넘기려고
        			            "text": result[i].emp_name + ' ' + result[i].job_title  + '(' +  result[i].emp_no + ')',
        			            "icon": "https://media.discordapp.net/attachments/692994434526085184/983044903678398604/5e8f55608965fadc.png"
        			            });
       					}
      					fnCreateJstree(json);
	        			
	        			// 조직도의 사원정보 상세보기
	        			$("#tree").click(function() {
	        		        $('ul li a').click(function() {
        		    			var emp_no = $(this).text().slice(-8, $(this).text().length - 1);
	        					$.ajax({
	        						url: '<%=request.getContextPath()%>/organ/selectdetailinfo'
	        						, data: {"emp_no":emp_no}
	        						, type: 'post'
	        						, success: function(result) {
	        							// 결과 값이 selectInfo.jsp여서 content자리를 html(result)로 바꿈!
	        							$("#s_dt_info_content").html(result);
	        						}
	        					});
	        				})
	        		    })
        		}	
        		, error: function() {
        			alert("실패 !");
        		}
        	});
        });
        
        // jstree 만드는 함수
        function fnCreateJstree(jsonData) {
		  $('#tree').jstree({
				'plugins': ["wholerow"],
				'core' : {
					'data' : jsonData,
					'state': {
						'opened' : true
					},
					'themes' : {
						'name' : 'proton',
						'responsive' : true
					}
				},
		        'plugins' : ["search"],
		        "search": {
		        	"case_sensitive": false,
		        	"show_only_matches": true
		        }
		
			});
        }
	</script>
	
	<script>
	$(function() {
		(function($) {
			$("#search").keyup(function() {
				var text = $("#search").val();
				$('#tree').jstree(true).search(text);
			});
		} (jQuery))
	});
    </script>

</body>
</html>