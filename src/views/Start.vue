<<template>
	<div class="back">
		<div class="logo"> <img src="src/logo/logo.png"> </div>
		<div class="center">
			<div  style="margin-top: 200px"><a class="chapter" id="admin" href="HomeAdmin">Сотрудник Департамента</a></div>
			<div> <a class="chapter" id="client" href="HomeClient">Сотрудник КФУ</a></div>
		</div>
		<div class="footer">© 2022 Федеральное государственное автономное образовательное учреждение высшего образования "Казанский (Приволжский) федеральный университет"</div>
	</div>
</template>-->


<script>
export default {
	name: "Start"
}
</script>

<style scoped>
.back {
	width: 100%;
	height: 90px;
	background: #005590;
	position: absolute;
	top: 0px;
	left: 0px;
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
	margin-right: auto;}

.chapter{
	font-weight: revert;
	text-decoration: none;
	display: inline-block;
	color: white;
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
	color: whitesmoke;
}

</style>-->

<!--
<template>
	<div>
		<ul id="example-1">
			<li v-for="item in items" :key="item.message">
				{{ item.message }}
			</li>
		</ul>
		<ul>
			<li v-for="n in evenNumbers">{{ n }}</li>
		</ul>
	</div>
</template>

<script>
export default {
	data() {
		return {
			items: [
				{message: 'Foo'},
				{message: 'Bar'}
			],
			numbers: [ 1, 2, 3, 4, 5 ]
		}
	},
	computed: {
		evenNumbers: function () {
			return this.numbers.filter(function (number) {
				return number % 2 === 0
			})
		}
	}
}
</script>
