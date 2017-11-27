<%@include file="/libs/foundation/global.jsp"%>
<%
    String first = request.getParameter("first");
    String last = request.getParameter("last");
    String city = request.getParameter("city");

 com.roche.pharma.customerportal.core.services.FormFrameworkService hf = sling.getService(com.roche.pharma.customerportal.core.services.FormFrameworkService.class);

%>
<%=hf.injestFormData(first,last,city)%>