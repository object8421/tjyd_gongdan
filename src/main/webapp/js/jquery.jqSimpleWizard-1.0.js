/*
 * jqSimpleWizard
 * @author Harley Ren.
 */

( function($,undefined) {

	$.widget("ui.simplewizard", {

		options : {
			onShowStep : null,
			onLeaveStep : null
		},

		_create : function ( args ) {
			this._steps = $("div.wizard-step",this.element);

			/** step count  */
			this._stepCount = this._steps.length;

			//Hide all steps.
			this._steps.hide();

			this._curStepIdx = -1;

		},


		/* public methods. */

		showStep :	function ( stepIdx ){
			if (stepIdx > this._stepCount - 1) {
				return;
			}

			this._showStep(stepIdx);
		},

		/**
		 * Show next step;
		 */
		nextStep : 	function () {
			if (this._curStepIdx >= this._stepCount - 1) {
				return;
			}

			this._showStep (this._curStepIdx + 1);
		},

		prevStep : function () {
			if (this._curStepIdx <= 0) {
				return;
			}

			this._showStep (this._curStepIdx - 1);

		},

		destroy : function () {
			//Hide all steps.
			this._steps.hide();

			this._curStepIdx = -1;

			$.Widget.prototype.destroy.apply(this, arguments);
		},

		/* private methods. */

		/**
		 * Show step at the specified index.
		 */
		_showStep : function (stepIndex) {
			var currentStep = this._steps.eq(this._curStepIdx < 0 ? 0 : this._curStepIdx);
			var toShowStep = this._steps.eq(stepIndex);
			var wizard = this;

			if( stepIndex > this._curStepIdx){
				if ( false === this._trigger( "onLeaveStep", null,currentStep ) ) {
					return;
				}
            }

			currentStep.fadeOut("fast",function() {
				toShowStep.fadeIn("fast");
//				向导中跳过第四步,{0,1,2,3,4} 当i=3时隐藏第四步
				for(var i = 0; i < wizard._stepCount; i++) {
					if (i != stepIndex && i != wizard._curStepIdx ) {
						wizard._steps.eq(i).hide();
					}
				}
                //$(this)._curStepIdx = stepIndex;
				//console.log($(this.parentElement).options);

				wizard._curStepIdx = stepIndex;
				wizard._trigger('onShowStep',null,toShowStep);
            });
		},

	});

})(jQuery);