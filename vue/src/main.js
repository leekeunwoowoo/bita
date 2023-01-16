import Vue from 'vue'
import App from './App'
import router from './router'
import BootstrapVue from "bootstrap-vue"
import Default from './Layout/Wrappers/baseLayout.vue';
import Pages from './Layout/Wrappers/pagesLayout.vue';
import tToast from "vue-bootstrap-toasts";
import axios from 'axios'
import vuetify from './plugins/vuetify';
import {store} from "./store/store";
//import 'material-design-icons-iconfont/dist/material-design-icons.css'

axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
axios.defaults.headers.post['Content-Type'] = 'application/json';
axios.defaults.timeout = 100000;
//운영
//axios.defaults.baseURL = 'http://ivisus.iptime.org:8090'
//개발
axios.defaults.baseURL = 'http://localhost:8090'
axios.defaults.withCredentials = true;

// 캐싱 방지
axios.defaults.headers.get['Cache-Control'] = 'no-cache';
axios.defaults.headers.get['Pragma'] = 'no-cache';

Vue.prototype.$http = axios;
Vue.use(BootstrapVue);
Vue.use(tToast);
Vue.config.productionTip = false;

Vue.component('default-layout', Default);
Vue.component('userpages-layout', Pages);

new Vue({
  el: '#app',
  router,
  vuetify,
  store: store,
  template: '<App/>',
  components: { App }
});
