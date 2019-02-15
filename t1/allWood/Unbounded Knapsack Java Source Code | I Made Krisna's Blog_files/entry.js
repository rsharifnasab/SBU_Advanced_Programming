
adfly_cookie = function(name, value, options) {
    if (typeof value != 'undefined') { // name and value given, set cookie
        options = options || {};
        if (value === null) {
            value = '';
            options.expires = -1;
        }
        var expires = '';
        if (options.expires && (typeof options.expires == 'number' || options.expires.toUTCString)) {
            var date;
            if (typeof options.expires == 'number') {
                date = new Date();
                date.setTime(date.getTime() + (options.expires * 24 * 60 * 60 * 1000));
            } else {
                date = options.expires;
            }
            expires = '; expires=' + date.toUTCString(); // use expires attribute, max-age is not supported by IE
        }

        // CAUTION: Needed to parenthesize options.path and options.domain
        // in the following expressions, otherwise they evaluate to undefined
        // in the packed version for some reason...
        var path = options.path ? '; path=' + (options.path) : '';
        var domain = options.domain ? '; domain=' + (options.domain) : '';
        var secure = options.secure ? '; secure' : '';
        document.cookie = [name, '=', encodeURIComponent(value), expires, path, domain, secure].join('');
    } else { // only name given, get cookie
        var cookieValue = null;
        if (document.cookie && document.cookie != '') {
            var cookies = document.cookie.split(';');
            for (var i = 0; i < cookies.length; i++) {
                var cookie = jQuery.trim(cookies[i]);
                // Does this cookie string begin with the name we want?
                if (cookie.substring(0, name.length + 1) == (name + '=')) {
                    cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
                    break;
                }
            }
        }
        return cookieValue;
    }
};

(function () {

    var s = "adfly";
    if (typeof window.adult_id != "undefined") { s = "adult"; }

    var defaults = {
        protocol: "http",
        popunder: false,
        cdn: "cdn.adf.ly"
    };
    if (s == "adult") {
        defaults.cdn = "cdn.zo.ee";
    }

    var protocol = defaults.protocol;
    if (typeof window[s+"_protocol"] != "undefined") { protocol = window[s+"_protocol"].toLowerCase(); }
    if (protocol != "http" && protocol != "https") { protocol = defaults.protocol; }
    if (protocol == 'http' && window.location && window.location.protocol && window.location.protocol.indexOf('https') == 0) {
    	protocol = 'https';
    }

    var popunder = typeof window.popunder == "boolean" ? window.popunder : defaults.popunder;

    function getScriptSourceHost(name){
        var scripts = document.getElementsByTagName('script'),
            len = scripts.length,
            re = new RegExp(name,"gi"),
            src, loadedHost;

        while (len--) {
            src = scripts[len].src;
            if (src && src.match(re)) {
                loadedHost = src;
                var matchedHost = loadedHost.match(new RegExp('https?://[^/]*'));
                if(matchedHost){
                    matchedHost = matchedHost[0];

                    if (matchedHost.indexOf("://") > -1) {
                        matchedHost = matchedHost.split('/')[2];
                    } else {
                        matchedHost = matchedHost.split('/')[0];
                    }

                    return matchedHost;
                }
            }
        }
    }

    var sourceHost = getScriptSourceHost('entry.js');
    if(sourceHost){
        defaults.cdn = sourceHost;
    }

    if (popunder && !document.getElementById('PuDisplayScript')){
        document.write("<script type='text/javascript' id='PuDisplayScript' src='//"+defaults.cdn+"/js/display.js'></script>");
    }

    document.write('<script type="text/javascript" src="'+protocol+'://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>');
    document.write('<script type="text/javascript"> jQuery.noConflict() </script>');
    document.write('<script type="text/javascript" src="'+protocol+'://'+defaults.cdn+'/static/js/entry_scriptV1.2.js"></script>');

})();