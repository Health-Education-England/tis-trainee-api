const CopyPlugin = require("copy-webpack-plugin");
const HtmlWebpackPlugin = require("html-webpack-plugin");
const HtmlWebpackTagsPlugin = require("html-webpack-tags-plugin");

module.exports = {
  mode: "development",
  output: {
    filename: "static/js/main.js"
  },
  plugins: [
    new CopyPlugin({
      patterns: [
        { from: "node_modules/swagger-ui/dist/swagger-ui.css", to: "static/css" },
        { from: "openapi.yml", to: "static"},
      ],
    }),
    new HtmlWebpackPlugin(),
    new HtmlWebpackTagsPlugin({
      tags: ["static/css/swagger-ui.css"],
    }),
  ],
};
