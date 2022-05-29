import Vue from 'vue';
import VueRouter from 'vue-router';
import Start from "./views/Start";
import HomeClient from "./views/Client/HomeClient";
import HomeAdmin from "./views/Admin/HomeAdmin";
import ApplicationAdminLoader from "./views/Admin/ApplicationAdminLoader";
import AcademicBuildingAdminLoader from "./views/Admin/AcademicBuildingAdminLoader";
import AdmissionAdminLoader from "./views/Admin/AdmissionAdminLoader";
import SetApplicationClientLoader from "./views/Client/SetApplicationClientLoader";
import AcademicBuildingClientLoader from "./views/Client/AcademicBuildingClientLoader";
import ApplicationClientLoader from "./views/Client/ApplicationClientLoader";
import AdmissionClientLoader from "./views/Client/AdmissionClientLoader";
import Loader from "./views/Loader";
import BuldingList from "./views/BuldingList";
import BuildingEdit from "./views/BuildingEdit";
import App from "./views/App";

Vue.use(VueRouter);
export default new VueRouter({
	mode: 'history',
	routes: [
		/*{path: "/", name: "loader", component: Loader},
		{path: "/app", component: App, children:[*/
		/*		{path: "/", name: "app", component: BuldingList},
				{path: "/:id", name: "edit", component: BuildingEdit}]},*/
		{path: "/", name: "start", component: Start},
		{path: "/homeClient", name: "homeClient", component: HomeClient},
		{path: "/homeAdmin", name: "homeAdmin", component: HomeAdmin},
		{path: "/applicationAdminLoader", name:"applicationAdminLoader" , component: ApplicationAdminLoader},
		{path: "/academicBuildingAdminLoader", name:"academicBuildingAdminLoader", component: AcademicBuildingAdminLoader},
		{path: "/admissionAdminLoader", name:"admissionAdminLoader", component: AdmissionAdminLoader},
		{path: "/setApplicationClientLoader", name: "setApplicationClientLoader" , component: SetApplicationClientLoader},
		{path: "/academicBuildingClientLoader", name: "academicBuildingClientLoader", component: AcademicBuildingClientLoader},
		{path: "/applicationClientLoader", name: "applicationClientLoader", component: ApplicationClientLoader},
		{path: "/admissionClientLoader", name: "admissionClientLoader", component: AdmissionClientLoader }
]});

