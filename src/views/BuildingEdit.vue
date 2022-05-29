<template>
	<div class="panel panel-primary" style="margin-top: 10px">
		<div class="panel-heading">Редактирование новости</div>
		<div class="panel-body">
			<form @submit="handleSubmit">
				<div class="form-group">
					<label for="inputTitle">name</label>
					<input type="text" class="form-control" id="inputTitle" v-model="name">
				</div>
				<div class="form-group">
					<label for="inputLink">address</label>
					<input type="url" class="form-control" id="inputLink" v-model="address">
				</div>
				<button type="submit" class="btn btn-primary pull-right">Сохранить</button>
			</form>
		</div>
	</div>
</template>

<script>
// import { sources } from "../config";
// import { formatInputDate, formatInputTime } from "../utils";
import {mapActions} from "vuex";

export default {
	data() {
		return {
			id: parseInt(this.$route.params.id),
			name: "",
			address: ""
		};
	},
	created() {
		if (this.id !== 0 && this.build) {
			this.name = this.build.name;
			this.address = this.build.address;
		}
	},
	methods: {
		async handleSubmit(e) {
			e.preventDefault();
			const build = {
				name: this.name,
				address: this.address,
			};
			if (this.id !== 0) {
				build.id = this.id;
				await this.editBuild(build);
			} else {
				await this.addBuild(build);
			}
			await this.$router.push({name: "app"});
		},
		...mapActions([
			'addBuild',
			'editBuild'
		])
	},
	computed: {
		build() {
			return this.id !== 0 ?
				this.$store.state.buildings.find(build => build.id === this.id):
				null;
		}
	}
}
</script>
