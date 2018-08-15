<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
</head>

<body >
 <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="39%" align="left">[员工管理]</td>
   
    <td width="57%"align="right">
    	<%--高级查询 --%>
		<a href="javascript:void(0)" onclick="javascript:document.getElementById('conditionFormId').submit();"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" /></a>
    	<%--员工注入 --%>
    	<s:a namespace="/" action="staffAction_addUI">
	  		<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
	  	</s:a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<!-- 查询条件：马上查询 -->
<s:form id="conditionFormId" namespace="/" action="staffAction_findAll">
	<table width="88%" border="0" style="margin: 20px;" >
	  <tr>
	    <td width="80px">部门：</td>
	    <td width="200px">
	    	<s:select list="allDepartments"  name="post.department.depId"
	    			  listKey="depId" listValue="depName"
	    			  headerKey="" headerValue="----请--选--择----"
	    			  onchange="showPost(this)"    	>
	    	</s:select>
	    </td>
	    <td width="80px" >职务：</td>
	    <td width="200px" >
 		    <s:select list="post != null ? post.department.postSet :{}" name="post.postId" id="postSelectId"
				listKey="postId" listValue="postName"
				headerKey="" headerValue="----请--选--择----"
			>
			</s:select>
	    </td>
	    <td width="80px">姓名：</td>
	    <td width="200px" ><s:textfield name="staffName" size="12"></s:textfield></td>
	    <td ></td>
	  </tr>
	</table>
</s:form>


<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>

<table width="100%" border="1" >
  <tr class="henglan" style="font-weight:bold;">
    <td width="10%" align="center">员工姓名</td>
    <td width="6%" align="center">性别</td>
    <td width="12%" align="center">入职时间</td>
    <td width="15%" align="center">所属部门</td>
    <td width="10%" align="center">职务</td>
    <td width="10%" align="center">编辑</td>
  </tr>
  <%-- 奇偶行 tabtd1 tabtd2--%>
    <s:iterator value="#allStaff" status="vs">
	  <tr class="<s:property value="#vs.even ? 'tabtd2' :'tabtd1'"/>" > 
	    <td align="center"> <s:property value="staffName" />  </td>
	    <td align="center"> <s:property value="gender" /> </td>
	    <td align="center"> <s:date name="onDutyDate" format="yyyy-MM-dd"/> </td>
	    <td align="center"> <s:property value="post.department.depName" /> </td>
	    <td align="center"> <s:property value="post.postName" /> </td>
	  	<td width="7%" align="center">
	  		<s:a name="/" action="staffAction_editUI">
	  			<s:param name="staffId" value="staffId"></s:param>
	  			<img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" /></a>	
	  		</s:a>
	  	</td>
	  	
	  </tr>
    </s:iterator>
	 
</table>


<%-- 
<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="right">
    	<span>第1/3页</span>
        <span>
        	<a href="#">[首页]</a>&nbsp;&nbsp;
            <a href="#">[上一页]</a>&nbsp;&nbsp;
            <a href="#">[下一页]</a>&nbsp;&nbsp;
            <a href="#">[尾页]</a>
        </span>
    </td>
  </tr>
</table>
--%>

<script type="text/javascript">
		function showPost(obj){
			var depId = obj.value;
			var xmlhttp=null;
			if (window.XMLHttpRequest){// code for all new browsers
			  xmlhttp=new XMLHttpRequest();
			} else if (window.ActiveXObject) {// code for IE5 and IE6
			  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.onreadystatechange = function(){
				if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
					var textData = xmlhttp.responseText;
					var jsonData = eval("("+textData+")");
					var postSelectElement = document.getElementById("postSelectId");
					postSelectElement.innerHTML = "<option value=''>----请--选--择----</option>";
					for(var i = 0 ; i < jsonData.length ; i++){
						var postObj = jsonData[i];
						var postId = postObj.postId;
						var postName = postObj.postName;
						postSelectElement.innerHTML += "<option value='"+postId+"'>"+postName+"</option>";
					}
				}
			};	
			var url = "${pageContext.request.contextPath}/postAction_findAllWithDepartment?department.depId=" + depId;
			xmlhttp.open("GET", url);
			xmlhttp.send(null);
		}
	</script>
</body>
</html>
