
import Vue from 'vue';
import Vuex from 'vuex';
import RssApi from './api';

Vue.use(Vuex);

export default new Vuex.Store({
	state:{
		buildings: [],
		alertText: ""
	},
	getters: {

	},
	mutations:{
		'SET_BUILDINGS'(state, buildings) {
			state.buildings = buildings;
		},
		'SET_ALERT_TEXT'(state, alertText) {
			state.alertText = alertText;
		},
		'ADD_BUILDINGS'(state, building){
			state.buildings.push(building);
		},
		'EDIT_BUILDINGS'(state, building) {
			const build = state.buildings.find(build => build.id === building.id);
			Object.assign(build, building);
		},
		'REMOVE_BUILDINGS'(state, building) {
			const index = state.buildings.findIndex(build => build.id === building.id);
			state.buildings.splice(index, 1);
		}
	},
	actions: {
		async initialize(context) {
			try {
				const response = await RssApi.building.getAll();
				context.commit('SET_BUILDINGS', response.data );
			} catch (error) {
				context.commit('SET_ALERT_TEXT', "Произошла ошибка" );
			}
		},
		async addBuild(context, build) {
			try {
				const response = await RssApi.rssBuild.add(build);
				context.commit('ADD_BUILDINGS', response.data );
			} catch (error) {
				context.commit('SET_ALERT_TEXT', "Произошла ошибка" );
			}
		},
		async editBuild(context, build) {
			try {
				const response = await RssApi.rssBuild.edit(build.id, build);
				context.commit('EDIT_BUILDINGS', response.data );
			} catch (error) {
				context.commit('SET_ALERT_TEXT', "Произошла ошибка" );
			}
		},
		async removeBuild(context, id) {
			try {
				const response = await RssApi.rssBuild.delete(id);
				context.commit('REMOVE_BUILDINGS', response.data );
			} catch (error) {
				context.commit('SET_ALERT_TEXT', "Произошла ошибка" );
			}
		}
	}
})
