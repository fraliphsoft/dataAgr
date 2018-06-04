/**
 * http://usejsdoc.org/
 */
function highlightRender() {
	$("code").each(function(index, element){
		$(element).html(Prism.highlight($(element).text(), Prism.languages.javascript));
	});
}