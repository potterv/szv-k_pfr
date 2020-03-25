<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by TEMPLATED
http://templated.co
Released for free under the Creative Commons Attribution License

Name       : Coefficient
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20131117

-->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!--<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>-->
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>



<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link href="css/default.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/fonts.css" rel="stylesheet" type="text/css" media="all" />

<!--[if IE 6]>
<link href="/css/default_ie6.css" rel="stylesheet" type="text/css" />
<![endif]-->
</head>
<body>
<div id="wrapper">
	<div id="header-wrapper">
		<!--<div id="header" class="container">
			<div id="logo">
				<h1><a href="#">И я стану </a></h1>
				<p>Пенсионером, <a href="http://pfrf.ru" rel="nofollow">если не умру</a></p>
			</div>
			<div id="social">
				<ul class="contact">
					<li><a href="#" class="icon icon-twitter"><span>Twitter</span></a></li>
					<li><a href="#" class="icon icon-facebook"><span></span></a></li>
					<li><a href="#" class="icon icon-dribbble"><span>Pinterest</span></a></li>
					<li><a href="#" class="icon icon-tumblr"><span>Google+</span></a></li>
					<li><a href="#" class="icon icon-rss"><span>Pinterest</span></a></li>
				</ul>
	          </div>
	     </div>-->
		   <div id="menu" class="container">
			<ul>
				<li class="current_page_item"><a href="/" accesskey="1" title="">Главная</a></li>
				<li><a href="#" accesskey="1" title="">Войти</a></li>
				<li><a href="/upload" accesskey="1" title="">Загрузить файлы на сервер </a></li>
				<li><a href="/getdate" accesskey="1" title="">Обработать загруженные файлы</a></li>
				<li><a href="/viewdate" accesskey="1" title="">Вывести результат</a></li>

			</ul>
		   </div>
	</div>
	<div id="page" class="container">
		<div class="column1">
			<div class="title">
				<h2>Подтверждение информации в ФМС</h2>
			</div>
			<p>Специалист загружает Файлы <strong>СЗВ-К</strong> в каталог на сервер, для обработки <a href="/upload" rel="nofollow">Загрузить файлы на сервер</a>. После загрузки файлов выполняется обработка содержимого файлов <a href="/getdate"> Выполнить обработку</a>. После чего выводится информация на экран. </p>
		</div>
		<div class="column2">
			<div class="title">
				<h2>Отправка запроса в ФМС</h2>
			</div>
			<br>
			<img src="images/pic01.jpg" width="282" height="150" alt="" />
			<p><a href="#" rel="nofollow">Выполнить выгрузку csv - файла  для ФМС<a/></p>
		</div>
		<div class="column3">
			<div class="title">
				<h2>Получение ответа от ФМС</h2>
			</div>
			<br>
			<img src="images/pic02.jpg" width="282" height="150" alt="" />
			<p><a href="#" rel="nofollow">Загрузка</a> полученого от ФМС файла на каком - либо носителе или по каналам связи</p>
		</div>
		<div class="column4">
			<div class="title">
				<h2>Обработка полученой информации</h2>
			</div>
			<img src="images/pic03.jpg" width="282" height="150" alt="" />
			<p>После загрузки файла с данными  полученого от ФМС, <a href="#" rel="nofollow">выводится  информация  о  факте проживания в г. Севастополе на 18.03.2014</a></p>
		</div>

		<div>

       	  <c:if test="${namePage=='index'}">
						<div class="index">

						</div>
         </c:if>




		<c:if test="${namePage=='viewdate'}">
			<div class="viewdate">
		<br/>
		<div>
			<h2> Данные о сотрудниках страхователей после обработки</h2>
		</div>

						 <form action="#" th:action="@{/greeting}" th:object="${greeting}" method="post">
						 <table border = 1 >

										 <tr>
											<th>
													UUID Пачки
												</th>
												<th>
													UUID Записи
												</th>
											 <th>
													 СНИЛС
											 </th>
											 <th>
													 Фамилия
												</th>
												<th>
												 Имя
												 </th>
												 <th>
												 Отчество
												 </th>
												 <th>
															Дата рождения
												 </th>


												 <th>
															Страна
												 </th>
												 <th>
															область
												 </th>
												 <th>
															Регион
												 </th>
												 <th>
															Город
												 </th>

										 </tr>
										 <c:forEach items="${employees}" var="employeeinfo">
										 <tr>
													<c:forEach var="count" begin="0" end="10">
															<td>
																	 <c:choose>
																			<c:when test="${(count==7)||(count==8)||(count==9)||(count==10)}">
																					<c:choose>
																						<c:when test="${fn:split(employeeinfo,',')[count]=='-'}">
																													 <p><input type="text" value="${fn:split(employeeinfo,',')[count]}" /></p>
																						</c:when>
																						<c:otherwise>
																							<c:out value="${fn:split(employeeinfo,',')[count]}"/>
																						</c:otherwise>
																					</c:choose>
																			</c:when>
																			<c:otherwise>
																					<c:out value="${fn:split(employeeinfo,',')[count]}"/>
																			</c:otherwise>
																	 </c:choose>
														</td>
													</c:forEach>
										 </tr>
										 </c:forEach>

						 </table>
							<p><input type="submit" value="Сохранить" /> </p>

							</form>
							</div>
					</c:if>
					 <c:if test="${namePage=='getdate'}">
              <div class="getdate">
							    <h2>${massege} </h2>
	            </div>
					 </c:if>



				<c:if test="${namePage=='upload'}">
          <div class="uploadFile">
					 <form:form method="post" enctype="multipart/form-data" modelAttribute="uploadedFile" action="uploadFile">
							<table>
								<tr>
									<td>Укажите путь к файлу для загрузки</td>
									<td><input type="file" name="file" /></td>
									<td style="color: red; font-style: italic;">
									<form:errors path="file" />
									</td>
								</tr>
								<tr>
							<td></td>
							<td><input type="submit" value="Загрузить файл СЗВ-К" /></td>
							<td></td>
								</tr>
							</table>
				   </form:form>

           </div>
				</c:if>


		</div>

	</div>
	<br/>

	<div id="portfolio-wrapper">
		<div id="portfolio" class="container">
			<!-- <div class="title">
				<h3>ОПФР по г. Севастополю</h3>
				<span class="byline">Отдел информационных технологий</span>
			</div>-->
			<div class="column1">
				<div class="box">
					<h3>Разработка и внедрение</h3>
					<p>Отдел информационных технологий</p><br>
					<a href="http://10.200.77.189:8080/intranet/ru_RU/group/g.sevastopol-/telefonnyj-spravocnik" class="button">Контакты сотрудников</a> </div>
			</div>
			<div class="column2">
				<div class="box">
					<h3>Прием входных данных (СЗВ-К)</h3>
					<p>Отдел персонифицированного учета</p>
					<a href="http://10.200.77.189:8080/intranet/ru_RU/group/g.sevastopol-/telefonnyj-spravocnik" class="button">Контакты сотрудников</a> </div>
			</div>
			<div class="column3">
				<div class="box">
					<h3>Обработка полученной информации</h3>
					<p>Группа по заблаговременной работе</p>
					<a href="http://10.200.77.189:8080/intranet/ru_RU/group/g.sevastopol-/telefonnyj-spravocnik" class="button">Контакты сотрудников</a> </div>
			</div>
		<!--	<div class="column4">
				<div class="box">
					<h3>Mauris vulputate dolor</h3>
					<p>Rutrum fermentum nibh in augue praesent urna congue rutrum.</p>
					<a href="http://10.200.77.189:8080/intranet/ru_RU/group/g.sevastopol-/telefonnyj-spravocnik" class="button">Etiam posuere</a> </div>
			</div>
		</div>-->
	</div>
</div>

<div id="footer">
	<p>&copy; ОПФР по г. Севастополю <a href="http://pfrf.ru" rel="nofollow">Н. Музыки 60а</a>. Портал для <a href="http://fotogrph.com/">заблаговременнолй работы</a>.</p>
</div>

</body>
</html>
