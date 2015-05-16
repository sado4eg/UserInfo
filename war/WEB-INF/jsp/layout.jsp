<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <title><tiles:insertAttribute name="title" ignore="true"/></title>
</head>

<body>
<table border="1" style="border-collapse: collapse;" cellpadding="2" cellspacing="2" align="center" width="800">
    <tbody>
    <tr>
        <td height="30" colspan="2"><tiles:insertAttribute name="header"/></td>
    </tr>
    <tr>
        <td width="150" height="450" valign="top">
            <tiles:insertAttribute name="navigation"/>
        </td>
        <td valign="top" width="650">
            <tiles:insertAttribute name="body"/>
        </td>
    </tr>
    <tr>
        <td height="30" colspan="2">
            <tiles:insertAttribute name="footer"/>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
