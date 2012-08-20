/**
 * Copyright 2012 - present by OpenGamma Inc. and the OpenGamma group of companies
 * Please see distribution for license.
 */
$.register_module({
    name: 'og.common.gadgets.curve',
    dependencies: ['og.common.gadgets.manager'],
    obj: function () {
        var prefix = 'og_curve_gadget_', counter = 1;
        var Curve = function (selector, input) {
            var $selector = $(selector), width = $selector.width(), height = $selector.height(),
                $hud, $plot, $plot_obj, hud = {}, curve = {}, data = {},
                color_arr = ['#42669a', '#ff9c00', '#00e13a', '#313b44'], background_color = '#f8f8f8',
                options = {
                    colors: [],
                    grid: {
                        borderWidth: 0, color: '#999', minBorderMargin: 0, labelMargin: 4,
                        hoverable: true, aboveData: false
                    },
                    lines: {lineWidth: 1, fill: false, fillColor: '#f8fbfd'},
                    legend: {
                        backgroundColor: null, show: true, labelBoxBorderColor: 'transparent', position: 'nw', margin: 1
                    },
                    pan: {interactive: true, cursor: "move", frameRate: 30},
                    selection: {mode: null},
                    series: {shadowSize: 1, points: {radius: 2, lineWidth: 1, fill: true, fillColor: "#ffffff"}},
                    xaxis: {mode: 'years', tickLength: 'full', labelHeight: 14, tickColor: '#fff'},
                    yaxis: {position: 'left', tickLength: 'full', labelWidth: 30, tickColor: '#fff'},
                    zoom: {interactive: true}
                };
            /**
              * Format data and update options
              */
            var formatter = function (data, options) {
                var obj = {options: options, data: []};
                data.forEach(function (val, i) {
                    if (val.curve) {
                        obj.data.push({data: val.curve});
                        obj.options.colors.push(color_arr[i]);
                    }
                    if (val.nodes) {
                        obj.data.push({data: val.nodes, points: {show: true}});
                        obj.options.colors.push(color_arr[i]);
                    }
                });
                return obj;
            };
            curve.load = function () {
                $.when(
                    og.api.text({module: 'og.views.gadgets.curve.curve_tash'}),
                    og.api.text({module: 'og.views.gadgets.curve.tooltip_tash'})
                ).then(function (tmpl_curve, tmpl_tooltip) {
                    var $html = $(tmpl_curve);
                    data = formatter(input, options);
                    $hud = $html.find('.og-js-hud');
                    $plot = $html.find('.og-js-curve').css({
                        width: width, height: height, 'background-color': background_color
                    });
                    $plot_obj = $.plot($plot, data.data, data.options);
                    $selector.empty().html($html);
                    hud.load(tmpl_tooltip);
                });
            };
            /**
             * Resets the curve zooming and panning
             */
            curve.reload = function () {
                $plot_obj = $.plot($plot, data.data, data.options);
                $selector.find('.og-reset').hide();
            };
            /**
             * Updates the curve data only. Preserves zooming and panning
             */
            curve.update = function (data) {
                $plot_obj.setData(formatter(data, options).data);
                $plot_obj.draw();
            };
            /**
             * Add tooltip and reset button
             */
            hud.load = function (tooltip_html) {
                var previous = null, sel = '.og-js-curve-tooltip';
                $plot.bind('plothover', function (event, pos, item) {
                    if (item && previous != item.dataIndex) {
                        $(sel).remove(), previous = item.dataIndex;
                        $((Handlebars.compile(tooltip_html))({x: item.datapoint[0], y: item.datapoint[1]}))
                            .appendTo('body').css({top: item.pageY + 5, left: item.pageX + 5}).show();
                    }
                    if (!item) $(sel).remove(), previous = null;
                });
                $plot.bind('plotpan plotzoom', function () {$selector.find('.og-reset').show();});
                $hud.css({position: 'absolute', top: 0, left: 0}).on('click', function () {curve.reload();});
            };
            return curve;
        };
        return function (config) {
            config.data = [
                {
                    curve: [
                        [0.02459016393442623, 0.0018060011461625827],
                        [0.04371584699453552, 0.002076640695228338],
                        [0.09016393442622951, 0.0023631408766479653],
                        [0.1721311475409836, 0.0033244274036651348],
                        [0.26229508196721313, 0.004353994402860873],
                        [0.5195074481622876, 0.0043019573857417046],
                        [0.7633430646006437, 0.004269684155888322],
                        [1.0099184070663971, 0.0042958688377172285],
                        [2.0099184070663974, 0.004846199774741556],
                        [3.007178681039, 0.005913726961415006],
                        [4.005464480874317, 0.007668908279876522],
                        [5.004438955011603, 0.009939502948991086],
                        [6.004438955011603, 0.012132388956713308],
                        [7.009918407066397, 0.014284336398286994],
                        [8.008196721311474, 0.016159939544590284],
                        [9.004438955011603, 0.01770050621711515],
                        [10.004438955011603, 0.019283215802868743],
                        [15.004438955011603, 0.02399867741581842],
                        [20.005464480874316, 0.025831020950183217],
                        [25.007178681039, 0.02675796697842828],
                        [30.009918407066397, 0.027182958134956005]
                    ],
                    nodes: [
                        [0.02459016393442623, 0.0018060011461625827],
                        [0.04371584699453552, 0.002076640695228338],
                        [0.09016393442622951, 0.0023631408766479653],
                        [0.1721311475409836, 0.0033244274036651348],
                        [0.26229508196721313, 0.004353994402860873],
                        [0.5195074481622876, 0.0043019573857417046],
                        [0.7633430646006437, 0.004269684155888322],
                        [1.0099184070663971, 0.0042958688377172285],
                        [2.0099184070663974, 0.004846199774741556],
                        [3.007178681039, 0.005913726961415006],
                        [4.005464480874317, 0.007668908279876522],
                        [5.004438955011603, 0.009939502948991086],
                        [6.004438955011603, 0.012132388956713308],
                        [7.009918407066397, 0.014284336398286994],
                        [8.008196721311474, 0.016159939544590284],
                        [9.004438955011603, 0.01770050621711515],
                        [10.004438955011603, 0.019283215802868743],
                        [15.004438955011603, 0.02399867741581842],
                        [20.005464480874316, 0.025831020950183217],
                        [25.007178681039, 0.02675796697842828],
                        [30.009918407066397, 0.027182958134956005]

                    ],
                    xaxis_label: 'Maturity',
                    yaxis_label: 'Percentage'
                },
                {
                    curve: [
                        [0.030054644808743168, 0.001747259234629301],
                        [0.04918032786885246, 0.001979044717476422],
                        [0.09562841530054644, 0.0023038396049420568],
                        [0.18032786885245902, 0.003269520225715705],
                        [0.26229508196721313, 0.004292962118948519],
                        [0.5140429672879707, 0.004242659770418563],
                        [0.7578785837263269, 0.00426002561459456],
                        [1.009933378246875, 0.004374565474147358],
                        [2.009933378246875, 0.00497966579199531],
                        [3.009933378246875, 0.006174573993260054],
                        [4.016393442622951, 0.007933840284916378],
                        [5.012673104274272, 0.010154978793241566],
                        [6.009933378246875, 0.012481187822595231],
                        [7.009933378246875, 0.01466244491789303],
                        [8.010928961748634, 0.01658672666858435],
                        [9.015412830301669, 0.018268130095082182],
                        [10.015412830301669, 0.019756535186674733],
                        [15.015412830301669, 0.024533883801098257],
                        [20.016393442622952, 0.026391708831029835],
                        [25.009933378246874, 0.027309637817120723],
                        [30.009933378246874, 0.02786847522930921]
                    ],
                    nodes: [
                        [0.030054644808743168, 0.001747259234629301],
                        [0.04918032786885246, 0.001979044717476422],
                        [0.09562841530054644, 0.0023038396049420568],
                        [0.18032786885245902, 0.003269520225715705],
                        [0.26229508196721313, 0.004292962118948519],
                        [0.5140429672879707, 0.004242659770418563],
                        [0.7578785837263269, 0.00426002561459456],
                        [1.009933378246875, 0.004374565474147358],
                        [2.009933378246875, 0.00497966579199531],
                        [3.009933378246875, 0.006174573993260054],
                        [4.016393442622951, 0.007933840284916378],
                        [5.012673104274272, 0.010154978793241566],
                        [6.009933378246875, 0.012481187822595231],
                        [7.009933378246875, 0.01466244491789303],
                        [8.010928961748634, 0.01658672666858435],
                        [9.015412830301669, 0.018268130095082182],
                        [10.015412830301669, 0.019756535186674733],
                        [15.015412830301669, 0.024533883801098257],
                        [20.016393442622952, 0.026391708831029835],
                        [25.009933378246874, 0.027309637817120723],
                        [30.009933378246874, 0.02786847522930921]
                    ],
                    xaxis_label: 'Maturity',
                    yaxis_label: 'Percentage'
                }
            ];
            var gadget = this, curve, alive = prefix + counter++;
            gadget.alive = function () {return !!$('.' + alive).length;};
            gadget.load = function () {
                $(config.selector)
                    .html('<div class="' + alive + '"></div>')
                    .find('div')
                    .css({position: 'absolute', top: 0, left: 0, right: 0, bottom: 0});
                curve = new Curve(config.selector + ' div', config.data);
                curve.load();
            };
            gadget.resize = gadget.load;
            gadget.load();
            if (!config.child) og.common.gadgets.manager.register(gadget);
            setInterval(function () {
                (function () {
                    var d = $.extend(true, [], config.data);
                    d.map(function (val) {
                        var index = Math.floor(Math.random() * val.curve.length);
                        val.curve[index][1] *= 1.05;
                        if (val.nodes) val.nodes[index][1] *= 1.05;
                        return val
                    });
                    curve.update(d);
                }());
            }, 1000);
        };
    }
});