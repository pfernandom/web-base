var webpack = require("webpack");
var packageJSON = require('./package.json');
var path = require('path');
var HtmlWebpackPlugin = require('html-webpack-plugin');
var FaviconsWebpackPlugin = require('favicons-webpack-plugin')


const PATHS = {
  build: path.join(__dirname, 'target', 'classes', 'META-INF', 'resources', 'webjars')
};


var configuration = {
	//devtool: 'cheap-module-source-map', 
	devtool: 'cheap-module-eval-source-map',
	entry: {
		main: ['./src/main/resources/app/app.js'],
		vendor: ['angular'],
	},
	output: {
		path: './src/main/resources/static/dist',
		filename: '[name].js',
	},
	devServer: {
		contentBase: __dirname,
		historyApiFallback: {
			index: 'index.html'
		}
	},
	module: {
		loaders: [
			{
				test: /\.css$/,
				loader: "style-loader!css-loader"
			},
			{
				test: /\.scss$/,
				exclude: /node_modules/,
				loaders: ['style', 'css', 'sass']
			},
			{
				test: /\.js$/,
				exclude: /node_modules/,
				loaders: ["babel-loader"],
			},
			{
				test: /\.woff(\?v=[0-9]\.[0-9]\.[0-9])?$/,
				loader: "url-loader?limit=10000&minetype=application/font-woff"
			},
			{
				test: /\.(ttf|eot|svg)(\?v=[0-9]\.[0-9]\.[0-9])?$/,
				loader: "file-loader"
			},
			{
				test: /\.woff(2)?(\?v=[0-9]\.[0-9]\.[0-9])?$/,
				loader: 'url-loader?limit=10000&mimetype=application/font-woff'
			},
			{
				test: /\.(ttf|otf|eot|svg)(\?v=[0-9]\.[0-9]\.[0-9])?|(jpg|gif)$/,
				loader: 'file-loader'
			},
			{
				test: /\.json$/,
				loader: 'json'
			},
			{
			    test: /\.html$/,
			    loader: 'html',
			    query: {
			      minimize: true
			    }
			}
		]
	},
	plugins: [
		new webpack.optimize.UglifyJsPlugin(),
        new webpack.optimize.DedupePlugin(),
        new webpack.DefinePlugin({
            'process.env': {
                'NODE_ENV': JSON.stringify('production')
            }
        }),
		new webpack.optimize.CommonsChunkPlugin({ name: 'vendor', filename: 'vendor.bundle.js', minChunks: Infinity }
		)
		/*,
		new HtmlWebpackPlugin({
			title: 'web-base',
			template: __dirname + '/src/main/resources/app/index.html',
			hash:true
		})
		new FaviconsWebpackPlugin('./src/images/pumpkin.svg')*/
	]
}

module.exports = configuration;