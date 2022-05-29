<template>
	<div class="back">
		<div class="logo"> <img src="src/logo/logo.png"> </div>
	<div class="content">
		<button id="back" class="btn"><a href="HomeAdmin">Назад</a></button>

		<table class="table">
			<thead>
			<tr>
				<th class="column fio" style="width: 35%">ФИО</th>
				<th class="column number" style="width: 15%">Гос. номер</th>
				<th class="column place" style="width: 25%">Объект КФУ</th>
				<th class="column status" style="width: 10%"></th>
			</tr>
			</thead>
			<tbody>
			<tr>
				<td>Иванов Сергей Михайлович</td>
				<td>А200РО121</td>
				<td>Второе учебное здание</td>
				<td>
					<button @click="toggleModal">Просмотр</button>
					<Modal :scrollable="true" v-show="isShowModal" :show="isShowModal" @close="toggleModal">
					<template #header>
							Пропуск №0043
						</template>
						<template #body>
								<div><b>ФИО:</b> Иванов Сергей Михайлович</div>
								<div><b>Структурное подразделение:</b> Департамент охраны</div>
								<div><b>Должность:</b> Охранник</div>
								<div><b>Телефон:</b> 89613448868</div>
								<br>
								<div><b>Марка автомобиля:</b> KIA</div>
								<div><b>Модель:</b> Seed</div>
								<div><b>Гос. номер:</b> А200РО121</div>
								<div><b>Цвет автомобиля:</b> черный</div>
								<div><b>ФИО владельца:</b> Иванов Сергей Михайлович</div>
								<br>
								<div><b>Объект КФУ:</b> Второе учебное здание</div>
						</template>
					</Modal>
				</td>
			</tr>
			<tr>
				<td>Илларионов Михаил Прокопьевич</td>
				<td>Л899ЛВ116</td>
				<td>Главное здание</td>
				<td>
					<button @click="toggleModal2">Просмотр</button>
					<Modal :scrollable="true" v-show="isShowModal2" :show="isShowModal2" @close="toggleModal2">
						<template #header>
							<div>Пропуск №0044</div>
						</template>
						<template #body>
								<div><b>ФИО:</b> Иванов Сергей Михайлович</div>
								<div><b>Структурное подразделение:</b> Департамент охраны</div>
								<div><b>Должность:</b> Охранник</div>
								<div><b>Телефон:</b> 89613448868</div>
								<br>
								<div><b>Марка автомобиля:</b> KIA</div>
								<div><b>Модель:</b> Seed</div>
								<div><b>Гос. номер:</b> А200РО121</div>
								<div><b>Цвет автомобиля:</b> черный</div>
								<div><b>ФИО владельца:</b> Иванов Сергей Михайлович</div>
								<br>
								<div><b>Объект КФУ:</b> Второе учебное здание</div>
						</template>
					</modal>
				</td>
			</tr>
			<tr>
				<td>Лавров Платон Дмитриевич</td>
				<td>Н131МХ1</td>
				<td>Главное здание</td>
				<td>
					<button @click="toggleModal3">Просмотр</button>
					<Modal :scrollable="true" v-show="isShowModal3" :show="isShowModal3" @close="toggleModal3">
					<template #header>
							<div >Пропуск №0045</div>
						</template>
						<template #body>
								<div><b>ФИО:</b> Лавров Платон Дмитриевич</div>
								<div><b>Структурное подразделение:</b> Департамент охраны</div>
								<div><b>Должность:</b> Преподаватель</div>
								<div><b>Телефон:</b> 89613448868</div>
								<br>
								<div><b>Марка автомобиля:</b> Volkswagen</div>
								<div><b>Модель:</b> Polo</div>
								<div><b>Гос. номер:</b> Н131МХ1</div>
								<div><b>Цвет автомобиля:</b> белый</div>
								<div><b>ФИО владельца:</b> Лавров Платон Дмитриевич</div>
								<br>
								<div><b>Объект КФУ:</b> Второе учебное здание</div>
						</template>
					</modal>
				</td>
			</tr>

			<tr>
				<td>Крылов Владимир Романович</td>
				<td>К415ТО116</td>
				<td>Нужина 1/7</td>
				<td><button>Просмотр</button></td>
			</tr>

			<tr>
				<td>Фадеев Артемий Арсенович</td>
				<td>К366УВ116</td>
				<td>Нужина 1/7</td>
				<td><button>Просмотр</button></td>
			</tr>

			<tr>
				<td>Успенский Лев Никитич</td>
				<td>С300ОЕ63</td>
				<td>Второе учебное здание</td>
				<td><button>Просмотр</button></td>
			</tr>

			<tr>
				<td>Климов Арсений Платонович</td>
				<td>С900ЕО16</td>
				<td>Главное здание</td>
				<td><button>Просмотр</button></td>
			</tr>

			<tr>
				<td>Меркулов Артём Тимофеевич</td>
				<td>К0621КТ716</td>
				<td>Главное здание</td>
				<td><button>Просмотр</button></td>
			</tr>

			</tbody>
		</table>
		<div class="footer">© 2022 Федеральное государственное автономное образовательное учреждение высшего образования "Казанский (Приволжский) федеральный университет"</div>
	</div>
	</div>
</template>


<script>
import Modal from 'C://Users//Ramil//Desktop//dec//123//Schedule — копия — копия//src//components//modal-window.vue';

export default {
	components: {
		Modal,
	},
	data: () => ({
		isShowModal: false,
		isShowModal2: false,
		isShowModal3: false,
	}),
	methods: {
		toggleModal() {
			this.isShowModal = !this.isShowModal;
		},
		toggleModal2() {
			this.isShowModal2 = !this.isShowModal2;
		},
		toggleModal3() {
			this.isShowModal3 = !this.isShowModal3;
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
	color:white;
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
