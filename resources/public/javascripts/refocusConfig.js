ReFocus.Config = {
  user_test_id: 1,
  task_id: 1,
  debug: true,
  env: 'production',
  clientSrc: '/refocus_core.js',
  endpoint: '/interactions',
  productionURL: 'http://staging.refocus.co/public'
};
if(window.location.search == '?production'){
  ReFocus.Config.env = 'production';
}
ReFocus.start();
