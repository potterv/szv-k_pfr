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

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
				<li><a href="/getdate" accesskey="1" title="">Обработать и вывести результат</a></li>

			</ul>
		   </div>
	</div>
	<div id="page" class="container">
		<div class="column1">
			<div class="title">
				<h2>Подтверждение информации в ФМС</h2>
			</div>
			<p>Специалист загружает Файлы <strong>СЗВ-К</strong>в каталог на сервер, для обработки <a href="/upload" rel="nofollow">Загрузить файлы на сервер</a>. После загрузки файлов выполняется обработка содержимого файлов <a href="/getdate"> Выполнить обработку</a>. После чего выводится информация на экран. </p>
		</div>
		<div class="column2">
			<div class="title">
				<h2>Отправка запроса в ФМС</h2>
			</div>
			<img src="images/pic01.jpg" width="282" height="150" alt="" />
			<p><a href="#" rel="nofollow">Выполнить выгрузку csv - файла  для ФМС<a/></p>
		</div>
		<div class="column3">
			<div class="title">
				<h2>Получение ответа от ФМС</h2>
			</div>
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
	</div>
	<br/>
    	<div>

           <c:if test="${namePage=='index'}">



           </c:if>

      <c:if test="${namePage=='getdate'}">
               <form action="#" th:action="@{/greeting}" th:object="${greeting}" method="post">
               <table border = 1>

                       <tr>
                        <td>
                            UUID Пачки
                          </td>
                          <td>
                            UUID Записи
                          </td>
                         <td>
                             СНИЛС
                         </td>
                         <td>
                             Фамилия
                          </td>
                          <td>
                           Имя
                           </td>
                           <td>
                           Отчество
                           </td>
                           <td>
                                Дата рождения
                           </td>


                           <td>
                                Страна
                           </td>
                           <td>
                                область
                           </td>
                           <td>
                                Регион
                           </td>
                           <td>
                                Город
                           </td>

                       </tr>
                      <c:forEach var="counter" begin="0" end="${employeesCount}">
                      <c:set var = "employee" value ="${employees[counter]} "/>
                       <tr>

                           <c:forEach var="count" begin="0" end="11">
                              <td>
                              <!-- <c:out value="${fn:split(employee,',')[count]}"/> -->


                                                                  <c:choose>
                                                                      <c:when test="${(count==7)||(count==8)||(count==9)||(count==10)}">

                                                                        <c:choose>
                                                                            <c:when test="${fn:split(employee,',')[count]=='-'}">
                                                                              <p>Id: <input type="text" th:field="*{id}" value="${fn:split(employee,',')[count]}" /></p>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <c:out value="${fn:split(employee,',')[count]}"/>
                                                                            </c:otherwise>
                                                                        </c:choose>

                                                                      </c:when>
                                                                      <c:otherwise>
                                                                          <c:out value="${fn:split(employee,',')[count]}"/>

                                                                      </c:otherwise>
                                                                  </c:choose>

                              </td>
                            </c:forEach>


                       </tr>
                   </c:forEach>
               </table>
                <p><input type="submit" value="Submit" /> </p>
                <!--<input type="reset" value="Reset" /></p>-->
                </form>
            </c:if>

            <c:if test="${namePage=='upload'}">
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


             </c:if>

    	</div>
	<div id="portfolio-wrapper">
		<div id="portfolio" class="container">
			<div class="title">
				<h2>ОПФР по г. Севастополю</h2>
				<span class="byline">Отдел информационных технологий</span> </div>
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
