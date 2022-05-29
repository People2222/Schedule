const path = require('path');
const webpack = require('webpack');
const ExtractTextPlugin = require("extract-text-webpack-plugin");

module.exports = {
	entry: './src/main.js',
	output: {
		path: path.resolve(__dirname, './dist'),
		publicPath: '/dist/',
		filename: 'app.js'
	},
	module: {
		rules: [
			{
				test: /\.js$/,
				loader: 'babel-loader',
				exclude: /node_modules/
			},
			{
				test: /\.(png|jpg|gif|svg)$/,
				loader: 'file-loader',
				options: {
					name: '[name].[ext]?[hash]'
				}
			}
		]
	},
	plugins: [
		new webpack.DefinePlugin({
			'process.env.NODE_ENV': JSON.stringify(process.env.NODE_ENV)
		})
	],
	resolve: {
		alias: {
			'vue$': 'vue/dist/vue.esm.js'
		},
		extensions: ['*', '.js', '.vue', '.json']
	},
	devServer: {
		historyApiFallback: true,
		noInfo: true,
		overlay: true
	},
	performance: {
		hints: false
	}
};

if (process.env.NODE_ENV === 'development'){
	module.exports.module.rules = (module.exports.module.rules || []).concat([{
		test: /\.css$/,
		use: [
			'vue-style-loader',
			'css-loader'
		]
	}, {
		test: /\.vue$/,
		loader: 'vue-loader',
		options: {
			loaders: {
				'scss': [
					'vue-style-loader',
					'css-loader',
					'sass-loader'
				],
				'sass': [
					'vue-style-loader',
					'css-loader',
					'sass-loader?indentedSyntax'
				]
			}
		}
	}]);
	module.exports.devtool = '#eval-source-map';
}

if (process.env.NODE_ENV === 'production') {
	module.exports.module.rules = (module.exports.module.rules || []).concat([{
		test: /\.css$/,
		use: ExtractTextPlugin.extract({
			use: 'css-loader',
			fallback: 'vue-style-loader'
		})
	}
	, {
		test: /\.vue$/,
		loader: 'vue-loader',
		options: {
			loaders: {
				css: ExtractTextPlugin.extract({
					use: 'css-loader',
					fallback: 'vue-style-loader'
				}),
				scss: ExtractTextPlugin.extract({
					use: [
						'css-loader',
						'sass-loader'
					],
					fallback: 'vue-style-loader'
				}),
				sass: ExtractTextPlugin.extract({
					use: [
						'css-loader',
						'sass-loader?indentedSyntax'
					],
					fallback: 'vue-style-loader'
				})
			}
		}
	}]);
	module.exports.plugins = (module.exports.plugins || []).concat([
		new webpack.optimize.UglifyJsPlugin({
			sourceMap: true,
			compress: {
				warnings: false
			}
		}),
		new webpack.LoaderOptionsPlugin({
			minimize: true
		}),
		new ExtractTextPlugin("app.css")
	]);
	module.exports.devtool = '#source-map';
}
