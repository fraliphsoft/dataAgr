/**
 * http://usejsdoc.org/
 */
function highlightRender() {
	$("row").each(function(index, element){
		$(element).html(Prism.highlight($(element).text(), Prism.languages.javascript));
	});
}