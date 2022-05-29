<template>
	<div class="panel panel-primary" style="margin-top: 10px">
		<div class="panel-heading">Список новостей</div>
		<div class="panel-body">
			<router-link role="button" class="btn btn-lg btn-block btn-default" :to="{name: 'edit', params: {id: 0}}">
				Добавить
			</router-link>
		</div>
		<table class="table table-striped">
			<thead>
			<tr>
				<th>id</th>
				<th style="width: 65%">name</th>
				<th style="width: 10%">address</th>
				<th style="width: 20px"></th>
				<th style="width: 20px"></th>
			</tr>
			</thead>
			<tbody>
			<tr v-for="(build, index) in buildings" :key="index">
				<td>{{index + 1}}</td>
				<td>{{ build.name }}</td>
				<td>{{ build.address}}</td>
				<td><router-link role="button" class="btn btn-sm btn-link" :to="{name: 'edit', params: {id: build.id}}">
					<span class="glyphicon glyphicon-pencil"></span>
				</router-link></td>
				<td><button type="button" class="btn btn-sm btn-link" @click="handleRemoveClick($event, build.id)">
					<span class="glyphicon glyphicon-remove"></span>
				</button></td>
			</tr>
			</tbody>
		</table>
	</div>
</template>

<script>
// import { sources } from "../config";
// import { formatDate } from "../utils";
import {mapActions, mapState} from 'vuex';

export default {
	methods: {
		async handleRemoveClick(e, id) {
			await this.removeBuild(id);
		},
		...mapActions([
			'removeBuild'
		])
	},
	computed: {
		// sources: () => sources,
		...mapState({
			buildings: state => state.buildings
		})
	}
}
</script>
