/*
const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})

module.exports = {
    runtimeCompiler: true,
    productionSourceMap: false,

    publicPath: process.env.NODE_ENV === 'production'
        ? './'
        : '/'
}
*/

const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
	//추가
    outputDir: '../src/main/resources/static',
    devServer: {
        port: 8091,
        //개발
        proxy: {'api': {target: 'http://localhost:8090','pathRewrite':{'^/':''},changeOrigin: true,"secure":false}},
        //운영
        //proxy: {'api': {target: 'http://ivisus.iptime.org:8090','pathRewrite':{'^/':''},changeOrigin: true,"secure":false}},
        //withCredentials:true,
        headers: {
            //'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*',
            'Access-Control-Allow-Credentials':true
        }    
	},
	runtimeCompiler: true,
	productionSourceMap: false,
	transpileDependencies: [
      'vuetify'
    ],
	lintOnSave: false,
	
	publicPath: process.env.NODE_ENV === 'production'
        ? './'
        : '/'
})

/*
module.exports = {
    //추가
    outputDir: '../src/main/resources/static',
    devServer: {
        port: 8090,
        proxy: {'api': {target: 'http://localhost:8090',changeOrigin: true,}}
        
	},
    chainWebpack: config => {
		const svgRule = config.module.rule("svg")
		svgRule.uses.clear();
		svgRule.use("vue-svg-loader").loader("vue-svg-loader");
	},
	transpileDependencies: true,
	lintOnSave:false
}
*/
