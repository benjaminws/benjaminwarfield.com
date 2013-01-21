var ReFocus = {
  start: function() {
    var config = ReFocus.Config;
    var refocusScript = document.createElement('script');
    refocusScript.type= 'text/javascript';

    if (config.env != 'production') {
      refocusScript.src = config.clientSrc;
    } else {
      refocusScript.src = config.productionURL + config.clientSrc;
    }

    var uxScript = document.getElementsByTagName('script')[0];
    uxScript.parentNode.insertBefore(refocusScript, uxScript);

    window.onload = function(){
      ReFocus.EventRecorder.init();
    }
    window.onbeforeunload = function(){
      ReFocus.EventRecorder.stopPump();
    }
  },

};
