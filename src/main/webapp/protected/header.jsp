<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header id="topbar">
  <div class="wrapper">
    <a href="/Dragsters/">
      <div class="logo">
        <h1>DRAGSTERS</h1>
      </div>
    </a>

    <div class="user-logged">

      <div class="user-information">
        <a href="LogoutController">
          <strong>${sessionScope.usuario.nome}</strong>
        </a>
      </div>
      <div class="user-avatar">
        <!-- <a href="<c:url value="/LogoutController"/>"> -->
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR7S9pKMslch4WjEcuH1FTueBDvu3nL4NTsNg&usqp=CAU"
          alt="avatar">
        <!-- </a> -->
      </div>
    </div>
</header>