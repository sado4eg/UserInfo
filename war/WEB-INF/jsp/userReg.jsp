<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
    .error {
        color: #ff0000;
        font-style: italic;
        font-weight: bold;
    }
</style>

<div style="text-align:center">
    <c:choose>
        <c:when test="${user eq null or hasErrors}">
            <h1>Please enter your information</h1>
            <form:form method="post" action="/userinfo/addUser">
                <table>
                    <tr>
                        <td><form:label path="firstName">First Name</form:label></td>
                        <td><form:input path="firstName"/></td>
                        <td><form:errors path="firstName" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="lastName">Last Name</form:label></td>
                        <td><form:input path="lastName"/></td>
                        <td><form:errors path="lastName" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="email">E-Mail Address</form:label></td>
                        <td><form:input path="email"/></td>
                        <td><form:errors path="email" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="Submit"/>
                        </td>
                    </tr>
                </table>
            </form:form>
        </c:when>
        <c:otherwise>
            <p>Hello, your user was successfully added</p>
            <table border="1">
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>E-Mail</th>
                </tr>
                <tr>
                    <td><c:out value="${user.firstName}"/></td>
                    <td><c:out value="${user.lastName}"/></td>
                    <td><c:out value="${user.email}"/></td>
                </tr>
            </table>
        </c:otherwise>
    </c:choose>
</div>