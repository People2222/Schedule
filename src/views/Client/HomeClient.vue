<template>
	<div class="back">
		<div class="logo"> <img src="src/logo/logo.png"> </div>
		<button id="back" class="btn"><a href="Start">Назад</a></button>
		<div class="center">

		<div class="chapter">
			<a id="setApplication" href="SetApplicationClientLoader">Подать заявление</a></div>
		<div class="chapter"><a id="buildingClient" href="AcademicBuildingClientLoader">Парковочные зоны</a></div>
		<div class="chapter"><a id="applicationClient" href="ApplicationClientLoader">История заявлений</a></div>
		<div class="chapter"><a id="admissionClient" href="AdmissionClientLoader">Действующие пропуска</a></div>
		<div class="footer">© 2022 Федеральное государственное автономное образовательное учреждение высшего образования "Казанский (Приволжский) федеральный университет"</div>
			</div>
	</div>
</template>

<script>
export default {
	name: "HomeClient"
}
</script>

<style scoped>
.back {
	color: white;
	width: 100%;
	height: 90px;
	background: #005590;
	position: absolute;
//top: 0px;
//left: 0px;
}
.logo{
	position: absolute;
	top: 0px;
	left: 30px;
	background-repeat: no-repeat;
}
.center{
	width: 60%;
	margin-left: auto;
	margin-right: auto;
}
.btn{
	color: white;
	font-weight: revert;
	text-decoration: none;
	width: 10%;
	border: 2px solid #0a68b4;
	padding: 3px 20px;
	margin: 15px;
	margin-top: 120px;
	margin-left: 65px;
	border-radius: 2px;
	font-size: 12px;;
	font-family: 'Montserrat', sans-serif;
	text-transform: uppercase;
	letter-spacing: 2px;
	background-image: linear-gradient(to right, #005fa0 0%, #4169E1 51%, #0000CD 100%);
	background-size: 200% auto;
	box-shadow: 0 0 20px rgba(0, 0, 0, .1);
	transition: .5s;
}
.chapter:hover {
	background-position: right center;
}
a{
	color:white;
}
.chapter{
	color: white;
	font-weight: revert;
	text-decoration: none;
	display: inline-block;
	width: 100%;
	padding: 20px 40px;
	margin-top: 15px;
	margin-left: auto;
	margin-right: auto;
	border-radius: 2px;
	font-size: 13px;
	font-family: 'Montserrat', sans-serif;
	text-transform: uppercase;
	letter-spacing: 2px;
	background-image: linear-gradient(to right, #005fa0 0%, #4169E1 51%, #0000CD 100%);
	background-size: 200% auto;
	box-shadow: 0 0 20px rgba(0, 0, 0, .1);
	transition: .5s;
}
.chapter:hover {
	background-position: right center;
}
.footer{
	position: fixed; /* Фиксированное положение */
	left: 0; bottom: 0; /* Левый нижний угол */
	padding: 8px; /* Поля вокруг текста */
	background: #4682b4; /* Цвет фона */
//color: #005590; /* Цвет текста */
	width: 100%; /* Ширина слоя */
	text-align: center;
	color: white;
}
</style>
