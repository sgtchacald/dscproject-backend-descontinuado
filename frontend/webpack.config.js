const webpack = require('webpack')

const MiniCssExtractPlugin = require("mini-css-extract-plugin")

module.exports = {
    mode: 'development',
    entry: './src/index.jsx',
    output: {
        path: __dirname + '/public',
        filename: './app.js'
    },
    devServer: {
        port: 3000,
        static: './public',
    },
    resolve: {
        extensions: ['', '.js', '.jsx'],
        alias: {
            modules: __dirname + '/node_modules',
            jquery: 'modules/jquery/dist/jquery.min.js',
            bootstrap: 'modules/admin-lte/plugins/bootstrap/js/bootstrap.js'
        }
    },
    plugins: [ 
        new webpack.ProvidePlugin({
            $: 'jquery',
            jQuery: 'jquery',
            'window.jQuery': 'jquery'
        })
    ],
    module: {
        rules: [
            {
                test: /\.m?js[x]$/,
                exclude: /node_modules/,
                use: {
                  loader: 'babel-loader',
                  options: {
                    presets: [
                      ['@babel/preset-env', { targets: 'defaults' }],
                      ['@babel/preset-react'],
                    ]
                  }
                }
            },
            {
                test: /\.css$/,
                use: ['style-loader', 'css-loader']
            },
            {
                test: /\.woff|.woff2|.ttf|.eot|.svg|.png|.jpg*.*$/,
                use: ['file-loader']
            }
          ]
    }
}