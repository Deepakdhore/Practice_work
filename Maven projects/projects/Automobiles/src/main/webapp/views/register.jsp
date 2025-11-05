<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head><title>Registration Form</title></head>
<body>
<h2>Register Here</h2>

<form:form modelAttribute="user" method="post">
    Username: <form:input path="username" /><br/><br/>
    Password: <form:password path="password" /><br/><br/>
    Gender:
    <form:radiobutton path="gender" value="Male" /> Male
    <form:radiobutton path="gender" value="Female" /> Female <br/><br/>
    Country:
    <form:select path="country">
        <form:option value="India" label="India"/>
        <form:option value="USA" label="USA"/>
        <form:option value="UK" label="UK"/>
    </form:select><br/><br/>
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>
