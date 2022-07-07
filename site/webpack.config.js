const path = require('path')

const webpack = require('webpack')

const HtmlWebpackPlugin = require('html-webpack-plugin')

const { CleanWebpackPlugin } = require('clean-webpack-plugin')

module.exports = {
    entry: {
        main: path.resolve(__dirname, './src/index.jsx'),
    },
    output: {
        path: path.resolve(__dirname, './dist'),
        filename: '[name].bundle.js',
    },
    devServer: {
        port: 3000,
        static: './public',
    },
    resolve: {
        extensions: ['', '.js', '.jsx','css'],
        alias: {
            modules: __dirname + '/node_modules',
            public: __dirname + '/public/'
        }
    },
    plugins: [
        new HtmlWebpackPlugin({
            title: 'dscproject-frontend',
            template: path.resolve(__dirname, './public/index.html'), // template file
            filename: 'index.html', // output file
        }),
        new CleanWebpackPlugin(),
        new webpack.ProvidePlugin({
            $: 'jquery',
            jQuery: 'jquery',
            'window.jQuery': 'jquery'
        }),
    ],
    module: {
        rules: [
            // JavaScript
            {
                test: /\.m?js[x]$/,
                exclude: /node_modules/,
                use: ['babel-loader'],
            },
            //Css
            {
                test: /\.css$/,
                use: ['style-loader', 'css-loader']
            },
            // Images
            {
                test: /\.(?:ico|gif|png|jpg|jpeg)$/i,
                type: 'asset/resource',
            },
        ],
    },
}