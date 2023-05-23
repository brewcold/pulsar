module.exports = ({ config }) => {
  // Don't use Storybook's default SVG Configuration
  config.module.rules = config.module.rules.map((rule) => {
    if (rule.test.toString().includes('svg')) {
      const test = rule.test
        .toString()
        .replace('svg|', '')
        .replace(/\//g, '');
      return { ...rule, test: new RegExp(test) };
    } else {
      return rule;
    }
  });

  config.module.rules.push(
    {
      test: /\.(js|jsx)$/,
      exclude: /node_modules/,
      use: ['babel-loader'],
    },
    {
      test: /\.(woff(2)?|ttf|eot)(\?v=\d+\.\d+\.\d+)?$/,
      use: ['file-loader'],
    },
    {
      test: /stories\.(js|jsx)?$/,
      loaders: [require.resolve('@storybook/addon-storysource/loader')],
      enforce: 'pre',
    },
    // Use SVG Configuration for SVGR yourself
    {
      test: /\.svg$/,
      use: ['@svgr/webpack'],
    }
  );

  return config;
};
