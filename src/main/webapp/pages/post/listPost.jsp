<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>

    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet"/>

</head>

<body>
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
        <td width="39%" align="left">[职务管理]</td>

        <td width="57%" align="right">
            <%--添加职务 --%>
            <a href="${pageContext.request.contextPath}/findDepartment.action">
                <img src="${pageContext.request.contextPath}/images/button/tianjia.gif"/>
            </a>

        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>
<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
    <tr>
        <td><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
    </tr>
</table>

<table width="100%" border="1">

    <tr class="henglan" style="font-weight:bold;">
        <th width="6%" align="center">部门名称</th>
        <th width="6%" align="center">职务名称</th>
        <th width="7%" align="center">编辑</th>
    </tr>
    <tbody>

    <s:iterator value="#session.pageBean.data" var="p">
        <tr class="tabtd1">
            <td align="center">${p.department.depName}</td>
            <td align="center">${p.postName}</td>
            <td width="7%" align="center">
                <a href="editPost.action?postId=${p.postId}&postName=${p.postName}&depID=${p.department.depID}">
               <img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
            </td>
        </tr>
    </s:iterator>
    </tbody>
</table>


<table border="0" cellspacing="0" cellpadding="0" align="center">
    <tr>
        <td align="right">
            <span>第<s:property value="#session.pageBean.pageNum"/>/<s:property
                    value="#session.pageBean.totalPage"/>页</span>
            <span>
<a href="findPostByPage">[首页]</a>&nbsp;&nbsp;
<a href="findPostByPage?pageNum=${session.pageBean.pageNum - 1}">[上一页]</a>&nbsp;&nbsp;
<s:iterator begin="#session.pageBean.start" end="#session.pageBean.end" var="num">
    <s:if test="#num <= #session.pageBean.totalPage">
<a href="findPostByPage?pageNum=${num}">
<s:property value="#num"/> </a>&nbsp;&nbsp;
    </s:if>
</s:iterator>
<a
        <c:choose>

            <c:when test="${pageBean.pageNum >= pageBean.totalPage}">href="#"</c:when>

            <c:otherwise>href="findPostByPage?pageNum=${pageBean.pageNum + 1}"</c:otherwise>

        </c:choose>
>[下一页]</a>&nbsp;&nbsp;
<a href="findPostByPage?pageNum=${pageBean.totalPage}">[尾页]</a>
</span>
        </td>
    </tr>
</table>
</body>
</html>
