<template>
	<div class="back">
		<div class="logo"> <img src="src/logo/logo.png"> </div>
	<form class="forma" action="#">
		<button id="back" class="btn_back"><a href="HomeClient">Назад</a></button>
		<h4> <span style="font-weight:bold">Заявление на выдачу постоянного транспортного пропуска на личную автомашину работника </span></h4>
		<fieldset>
			<legend>Контактная информация работника</legend>
			<table>
				<tr>
					<td class="column1"><label for="name">ФИО </label></td>
					<td class="column2"><input id="name"><br></td>
				</tr>
				<tr>
					<td><label for="chapter">Структурное подразделение</label></td>
					<td> <select id="chapter">
						<option value="female">Департамент охраны</option>
						<option value="male">Институт вычислительной математики и информационных технологий</option>
						<option value="male">Высшая школа экономики</option>
					</select><br></td>
				</tr>
				<tr>
					<td><label for="email">Должность</label></td>
					<td>	<input id="email"><br></td>
				</tr>
				<tr>
					<td><label for="telephone">Телефон</label></td>
					<td><input id="telephone"><br></td>
				</tr>
			</table>
		</fieldset>

		<fieldset>
			<legend>Данные автотранспорта</legend>
			<table>
				<tr>
					<td class="column1"><label for="marka">Марка</label></td>
					<td class="column2"><input id="marka"><br></td>
				</tr>
				<tr>
					<td><label for="model">Модель</label></td>
					<td><input id="model"><br></td>
				</tr>
				<tr>
					<td><label for="number">Гос. номер</label></td>
					<td><input id="number"><br></td>
				</tr>
				<tr>
					<td><label for="color">Цвет</label></td>
					<td><input id="color"><br></td>
				</tr>
				<tr>
					<td><label for="name_owner">ФИО владельца</label></td>
					<td><input id="name_owner"><br></td>
				</tr>
			</table>
		</fieldset>

		<fieldset>
			<legend>Выберите объект КФУ, для доступа на парковку которого нужен пропуск</legend>
			<table>
				<tr>
					<td><label for="building">Объект КФУ</label></td>
					<td> <select id="building">
						<option value="female">Главное учебное здание</option>
						<option value="male">Второе учебное здание</option>
						<option value="male">Нужина 1/7</option>
					</select><br></td>
				</tr>
			</table>
		</fieldset>
		<button class="btn">Отправить заявление</button>
	</form>
		<div class="footer">© 2022 Федеральное государственное автономное образовательное учреждение высшего образования "Казанский (Приволжский) федеральный университет"</div>
	</div>
</template>

<script>
export default {
	name: "SetApplicationLoader"
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

.forma{
	padding-top: 20px;
	min-width: 400px;
	width: 70%;
	margin-left: auto;
	margin-right: auto;
	font-family: "Times New Roman";
	//color: white;
	//color: lightslategrey;
}
h4{
	max-width: 700px;
	margin-right: auto;
	margin-left: auto;
	text-align: center;
	color: black;
}
legend{
	padding-top: 20px;
	//color: lightslategrey;
}
input, select{
	margin-left: 40px;
	//color: lightslategrey;
}
td{
	padding-top: 10px;
	//color: lightslategrey;
}
input, select{
	width: 100%;
	padding: 3px;
	padding-left: 10px;
	color: black;
}
label{
	font-size: 15px;
	//color: lightslategrey;
}
.column1{
	width: 30%;
 // color: lightslategrey;
	font-weight: bold;
}
.column2{
	width: 70%;
//	color: lightslategrey;
	font-weight: bold;
}
table{
	width: 100%;
	color: black;
}
legend{
	font-size: 20px;
	//color: lightslategrey;
	font-weight: bold;
}
.btn{
	color: white;
	font-weight: revert;
	text-decoration: none;
	width: 60%;
	border: 2px solid #0a68b4;
	padding: 3px 20px;
	margin: 50px 20% 80px 20%;


	/*margin: 50px 50px 70px 50px;*/

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
.btn_back {
	color: white;
	font-weight: revert;
	text-decoration: none;
	width: 10%;
	border: 2px solid #0a68b4;
	padding: 3px 20px;
	margin: 15px;
	margin-top: 100px;
	margin-left: 0px;
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
a
{
 color: whitesmoke;
}

.footer{
	position: fixed; /* Фиксированное положение */
	left: 0; bottom: 0; /* Левый нижний угол */
	padding: 8px; /* Поля вокруг текста */
	background: #4682b4; /* Цвет фона */
//color: #005590; /* Цвет текста */
	width: 100%; /* Ширина слоя */
	text-align: center;
	color: whitesmoke;
}
/** {
	font-family: 'Palatino Linotype', serif;
	max-width: 1000px;
	padding: 0px 30px;
}

h1 {
	margin-bottom: 0px;
}

p {
	margin-top: 0px;
}

fieldset {
	margin-bottom: 15px;
	padding: 10px;
}

legend {
	padding: 0px 3px;
	font-weight: bold;
	font-variant: small-caps;
}

label {
	width: 110px;
	display: inline-block;
	vertical-align: top;
	margin: 6px;
}

em {
	font-weight: bold;
	font-style: normal;
	color: #f00;
}

input:focus {
	background: #eaeaea;
}

input, textarea {
	width: 300px;
}

textarea {
	height: 100px;
}

select {
	width: 254px;
}

input[type=checkbox] {
	width: 10px;
}

input[type=submit] {
	width: 170px;
	padding: 30px;
}*/
</style>
