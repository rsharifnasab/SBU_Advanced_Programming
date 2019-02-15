/** JS Logics */
(function($){
	
	/** Drop Downs */
	function faradMenu() {
		
		/** Superfish Menu */
		$( '.menu ul' ).supersubs({			
			minWidth: 12,
			maxWidth: 25,
			extraWidth: 0			
		}).superfish({		
			delay: 1200, 
			autoArrows: false,
			dropShadows: false		
		});
		
	}
	
	/** Tweaks */
	function faradTweaks() {
		
		/** Widget List Last Child */
		$( '.widget ul li:last-child' ).css({ 'margin-bottom':'0', 'padding-bottom':'0' });
	
	}
	
	/** jQuery Document Ready */
	$(document).ready(function(){
		faradMenu();
		faradTweaks();
	});
	
	/** jQuery Windows Load */
	$(window).load(function(){
	});

})(jQuery);