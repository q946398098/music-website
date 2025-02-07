const { defineConfig } = require('@vue/cli-service')

module.exports = defineConfig({
  transpileDependencies: true,
  chainWebpack: config => {
    config.plugin('define').tap(definitions => {
      Object.assign(definitions[0]['process.env'], {
        NODE_HOST: '"http://localhost:8888"',
      });
      return definitions;
    });
  },
  // devServer: {
  //   proxy: {
  //     '/api': {
  //       target: 'http://localhost:8888', // 后端服务地址
  //       changeOrigin: true, // 是否改变请求的源头
  //       pathRewrite: {
  //         '^/api': '' // 重写路径，去掉 /api 前缀
  //       }
  //     }
  //   }
  // }
})
