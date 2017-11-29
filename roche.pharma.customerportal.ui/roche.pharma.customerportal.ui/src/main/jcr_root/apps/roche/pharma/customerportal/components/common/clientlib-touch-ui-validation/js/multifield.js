/*
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Validation for Granite Touch UI multifield component.
 *
 * Additional properties for granite/ui/components/foundation/form/multifield
 * are:
 *
 * {Long}min
 * The minimum number of multifield items
 * No default
 *
 * {Long}max
 * The maximum number of multifield items
 * No default
 *
 * During usage, the multifield's add button will disable if the max is reached.
 * Upon dialog submission, the size is checked against the min and max fields
 * thereby rendering min as a 'required' field validation.
 *
 *  <myMultifield
 *       jcr:primaryType="nt:unstructured"
 *       sling:resourceType="granite/ui/components/foundation/form/multifield"
 *       fieldLabel="My multifield"
 *       min="{Long}2"
 *       max="{Long}5">
 *       <field
 *           jcr:primaryType="nt:unstructured"
 *           sling:resourceType="granite/ui/components/foundation/form/textfield"
 *           name="./myTextfield" />
 *   </myMultifield>
 */
(function (ns, window, document, $, Granite, undefined) {
	
	var MULTIFIELD_SELECTOR = '.coral-Multifield',
	ADD_BUTTON_SELECTOR = '.coral-Multifield-add',
	REMOVE_BUTTON_SELECTOR = '.coral-Multifield-remove';

	$(window).adaptTo('foundation-registry').register('foundation.adapters', {
		type: 'aemTouchUIValidation-field',
		selector: '.coral-Multifield',
		adapter: function (el) {
			var $multifield,
			$addButton,
			$items;

			$multifield = $(el);
			$addButton = $multifield.children('.coral-Multifield-add');

			return {
				setDisabledAdd: function (disabled) {
					$addButton.attr('disabled', disabled);
				},
				size: function () {
					$items = $multifield.children('ol').children();
					return $items.length;
				}
			};
		}
	});


	/**
	 * Assign multifield event handlers and listeners when a Granite UI dialog
	 * loads.
	 */
	$(document).on('foundation-contentloaded', function (e) {
		var $dialog,
		$multifields;

		$dialog = $(e.target);
		$multifields = $dialog.find(MULTIFIELD_SELECTOR);

		/**
		 * Handle multifield add events.
		 *
		 * Check the maximum length of the multifield set as a data attribute.
		 * Disable the multifield addition button if the additional list item
		 * reaches the max.
		 */
		$multifields.on('multifield:add', function () {
			var $multifield,
			$counter,
			api,
			min,
			max;

			$multifield = $(this);
			api = $multifield.adaptTo('aemTouchUIValidation-field');
			$counter = $multifield.children('.marker-multifield');
			min = $multifield.data('min');
			max = $multifield.data('max');

			var count = parseInt($counter.val(), 10) + 1;

			$counter.val(count);

			/*
			 * If the field has already been validated, check again because the 'add'
			 * button was clicked. Wait until the first validation because we don't
			 * want an error message as the user starts adding from nothing.
			 */
			if ($counter.validationMessage()) {
				$counter.change();
			}

			$multifield.trigger('multifield:update');
		});

		/**
		 * Handle multifield removal events.
		 *
		 * Enable the multifield 'add' button.
		 */
		$multifields.on('multifield:remove', function () {
			var $multifield,
			$counter,
			api;

			$multifield = $(this);
			$counter = $multifield.children('.marker-multifield');
			api = $multifield.adaptTo('aemTouchUIValidation-field');

			var count = parseInt($counter.val(), 10) - 1;
			$counter.val(count);

			/* update validation */
			$counter.change();

			api.setDisabledAdd(false);
		});

		/**
		 * Handle multifield update events.
		 *
		 * Disable the 'add' button if the multifield reaches the max limit.
		 */
		$multifields.on('multifield:update', function () {
			var $multifield,
            $counter,
			api,
			max;

			$multifield = $(this);
			api = $multifield.adaptTo('aemTouchUIValidation-field');
            $counter = $multifield.children('.marker-multifield');
            var count = parseInt($counter.val(), 10);
			max = $multifield.data('max');

			if (count >= max) {
				setTimeout(function () {
					api.setDisabledAdd(true);
				}, 10);
			}
		});

		/**
		 * Assign add and remove event handlers on click events for buttons.
		 *
		 * There's only one add button per multifield so the event is attached
		 * directly on the button. The remove buttons must be handled with event
		 * delegation as by the time this code runs, the list item has been removed
		 * from the DOM making it more difficult to find the parent multifield.
		 * Trigger update event handler on load to disable the button if the max
		 * is already reached.
		 */
		$multifields.each(function () {
			var $multifield = $(this),
			api = $multifield.adaptTo('aemTouchUIValidation-field'),
			min = $multifield.data('min'),
			max = $multifield.data('max');

			var $counter = $('<input type="text" class="marker-multifield coral-InputGroup-input coral-Textfield">')
				.val(api.size());

			$multifield.prepend($counter);

			$multifield
			.find(ADD_BUTTON_SELECTOR)
			.click(function () {
				$multifield.trigger('multifield:add');
			})
			.trigger('multifield:update');

			$multifield.on('click', REMOVE_BUTTON_SELECTOR, function () {
				$multifield.trigger('multifield:remove');
			});
		});
	});

})(window.aemTouchUIValidation = window.aemTouchUIValidation || {}, window, document, Granite.$, Granite);
