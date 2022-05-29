<template>
	<div class="back">
		<div class="logo"> <img src="src/logo/logo.png"> </div>
		<div class="content">
		<button id="back" class="btn"><a href="HomeAdmin">Назад</a></button>

		<table class="table">
			<thead>
			<tr>
				<th class="column fio" style="width: 40%">Наименование объекта</th>
				<th class="column number" style="width: 40%">Адрес</th>
				<th class="column place" style="width: 20%"></th>
			</tr>
			</thead>
			<tbody>
			<tr>
				<td>Главное здание КФУ</td>
				<td>ул. Кремлевская, 18</td>
				<td>
					<button @click="toggleModal">Просмотр</button>
					<Modal :scrollable="true" v-show="isShowModal" :show="isShowModal" @close="toggleModal">
						<template #header>
							<div>Парковочная зона</div>
						</template>
						<template #body>
								<div><b>Объект:</b> Главное здание КФУ</div>
								<div><b>Адрес:</b> ул. Кремлевская, 18</div>
								<br>
								<div><b>Количество парковочных мест:</b> 104</div>
								<br>
								<img src="src/logo/1.png" style="width: 100%; margin-bottom: 10px">
						</template>
					</Modal>
				</td>
			</tr>
			<tr>
				<td>Второй учебный корпус КФУ</td>
				<td>ул. Кремлевская, 35</td>
				<td><button @click="toggleModal">Просмотр</button></td>
			</tr>
			<tr>
				<td>Нужина 1/7</td>
				<td>ул. Профессора Нужина, 1/7</td>
				<td><button @click="toggleModal">Просмотр</button></td>
			</tr>
			</tbody>
		</table>
			<div class="footer">© 2022 Федеральное государственное автономное образовательное учреждение высшего образования "Казанский (Приволжский) федеральный университет"</div>
	</div>
	</div>
</template>

<script>import Modal from 'C://Users//Ramil//Desktop//dec//123//Schedule — копия — копия//src//components//modal-window.vue'	;

export default {
	name: 'app',
	components: {
		Modal,
	},
	data: () => ({
		isShowModal: false,
	}),
	methods: {
		toggleModal() {
			this.isShowModal = !this.isShowModal;
		},
	},
};
</script>

<style scoped>
.back{
	width: 100%;
	height: 90px;
	background: #005590;
	position: absolute;
	top: 0px;
	left: 0px;
}
.chapter{
	border:  2px solid #0a68b4;
	padding: 10px 15px;
	font-size: 18px;
	margin-top: 20px;
	width: 60%;
	margin-left: auto;
	margin-right: auto;
	color: black;
}
.content{
	width: 75%;
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
	margin-top: 10px;
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

a{
	color: white;
}
.table {
	width: 100%;
	margin-bottom: 20px;
	border: 15px solid #F2F8F8;
	border-top: 5px solid #F2F8F8;
	border-collapse: collapse;
}
.table th {
	font-weight: bold;
	padding: 8px;
	background: #F2F8F8;
	border: none;
	border-bottom: 5px solid #F2F8F8;
}
.table td {
	padding: 5px;
	border: none;
	border-bottom: 5px solid #F2F8F8;
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
</style>
