<%@include file="/libs/foundation/global.jsp"%>
<%
    String first = request.getParameter("first");
    String last = request.getParameter("last");
    String city = request.getParameter("city");

 com.roche.pharma.customerportal.core.services.SampleFormService sample = sling.getService(com.roche.pharma.customerportal.core.services.SampleFormService.class);

%>
<%=sample.injestFormData(first,last,city)%>