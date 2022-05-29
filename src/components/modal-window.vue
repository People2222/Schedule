<!--
<template>
&lt;!&ndash;	<transition name="modal-fade">
		<div class="contentModel">
			<div
				class="modal"
					 role="dialog"
					 aria-labelledby="modalTitle"
					 aria-describedby="modalDescription">
				<div>
					<button type="button" class="btn-close" @click="closeModal" aria-label="Close modal"> x </button>
				</div>

				<header class="modal-header" id="modalTitle">
					<slot name="header">
						This is the default title!
					</slot>
				</header>

				<section class="modal-body" id="modalDescription">
					<slot name="body">
						I'm the default body!
					</slot>
				</section>

				<footer class="modal-footer">
					<slot name="footer">

					</slot>
				</footer>
			</div>
		</div>
	</transition>&ndash;&gt;
	<script type="text/x-template" id="modal-template">
	<transition name="modal">
		<div class="modal-mask">
			<div class="modal-wrapper">
				<div class="modal-container">

					<div class="modal-header">
						<slot name="header">
							default header
						</slot>
					</div>

					<div class="modal-body">
						<slot name="body">
							default body
						</slot>
					</div>

					<div class="modal-footer">
						<slot name="footer">
							default footer
							<button class="modal-default-button" @click="$emit('close')">
								OK
							</button>
						</slot>
					</div>
				</div>
			</div>
		</div>
	</transition>
	</script>
</template>

<script>
export default {
	name: 'modal',
	/*methods: {
		closeModal: function () {
			this.show = false
		}
	},*/
	template: "#modal-template"
};
</script>

<style>

.contentModel{
	font-family: Arial;
	color: black;
}
.modal {
	width: 60%;
	margin-left: auto;
	margin-right: auto;
	height: 80%;
	margin-top: auto;
	margin-bottom: auto;
	background: #FFFFFF;
	box-shadow: 2px 2px 20px 1px;
	overflow-x: auto;
	display: flex;
	flex-direction: column;
}

.btn-close {
	border: none;
	font-size: 20px;
	padding-top: 20px;
	padding-right: 40px;
	cursor: pointer;
	font-weight: bold;
	color: #005fa0;
	background: transparent;
	float:right;
}

.modal-header {
	margin-left: auto;
	margin-right: auto;
	font-size: 23px;
	padding-top: 0px;
}

.modal-body{
	padding-right: 40px;
	padding-top: 0;
	font-size: 15px;
	height: 280px;
}
.button{
	margin-right: 15px;
	border: black solid 1px;
	background: #ffffff;
	padding: 2px 10px;
	color: #323232;
	border-radius: 3px;
}

</style>
-->

<template>
	<div class="simple-modal">
		<div
			class="simple-modal-backdrop"
			@click="closeModal"
		>
			<div class="simple-modal-container">
				<div
					class="simple-modal-content simple-modal-scrollable"
					@click.stop
				>
					<header class="simple-modal-header">
						<slot name="header">
							Modal title
						</slot>
					</header>
					<section class="simple-modal-body">
						<slot name="body">
							Modal body
						</slot>
					</section>
					<footer class="simple-modal-footer">
						<slot name="footer" />
						<button
							type="button"
							@click="closeModal"
						>
							Закрыть
						</button>
					</footer>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
export default {
	name: 'Modal',
	methods: {
		closeModal() {
			this.$emit('close');
		},
	},
	scrollable: {
		type: Boolean,
		default: false,
	},
};
</script>

<style>
.simple-modal-backdrop {
		position: fixed;
		top: 0;
		bottom: 0;
		left: 0;
		right: 0;
		width: 100%;
		height: 100%;
		background-color: rgba(0, 0, 0, 0.8);
		transition: opacity 0.3s ease;
		z-index: 9999;
}

.simple-modal-container {
		position: fixed;
		top: 0;
		right: 0;
		left: 0;
		bottom: 0;
		width: auto;
		margin: 16px;
	}
.simple-modal-scrollable {
	max-height: 95%;
	overflow-y: auto;
}
.simple-modal-content {
		display: flex;
		flex-direction: column;
		justify-content: space-between;
		width: 100%;
		max-width: 500px;
		margin: 1.75rem auto;
		padding: 20px 30px;
		border-radius: 5px;
		color: #000;
		background-color: #fff;
		transform: translate(0, 0);
		transition: all 0.3s ease;
		box-sizing: border-box;
	}

.simple-modal-header {
		padding-bottom: 16px;
		font-size: 25px;
		text-align: center;
	}

.simple-modal-footer {
		display: flex;
		flex-direction: column;
		justify-content: center;
		height: 80px;
		text-align: center;
}
</style>
