<template>
	<div>
		<main class="container">
			<router-view></router-view>
		</main>
		<alert-snack :text="alertText"></alert-snack>
	</div>
</template>

<script>
import AlertSnack from "../components/AlertSnack";
import { mapState } from 'vuex';

export default {
	computed: {
		...mapState({
			alertText: state => state.alertText
		})
	},
	components: {
		AlertSnack
	}
}
</script>
