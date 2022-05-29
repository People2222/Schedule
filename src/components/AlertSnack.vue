<template>
	<div class="alert alert-snackbar" role="alert" id="errorAlert" v-show="isVisible">
		<button type="button" class="close" aria-label="Close" @click="handleCloseClick">
			<span aria-hidden="true">&times;</span>
		</button>
		<div class="alert-snackbar-text">{{ text }}</div>
	</div>
</template>

<script>
	export default {
		props: [
			"text"
		],
		data() {
			return {
				isVisible: this.text !== ""
			}
		},
		methods: {
			handleCloseClick(e) {
				this.isVisible = false;
			}
		}
	}
</script>

<style scoped>
	.alert-snackbar {
		width: 768px;
		position: fixed;
		z-index: 1;
		border-radius: 2px;
		margin-bottom: 0;
		bottom: 0;
		left: 50%;
		margin-left: -384px;
		padding: 12px;
		box-shadow: 0 0 6px 1px rgba(0, 0, 0, 0.4);
		background-color: #323232;
	}

	.alert-snackbar > .alert-snackbar-text {
		position: relative;
		width: 100%;
	}

	.alert-snackbar > .close {
		padding-bottom: 3px;
		line-height: 22px;
		width: 25px;
		position: relative;
		z-index: 2
	}
	.alert-snackbar > .close :focus {
			outline: none;
	}

	@media (max-width: 768px) {
		.alert-snackbar {
			width: 100%;
			left: 0;
			margin-left: 0;
			border-radius: 0;
		}
	}
</style>
