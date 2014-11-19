$a(document).ready(function() {	
	
   
	var countriesArray = $a.map(countries, function (value, key) { return { value: value, data: key }; });
	
    $a('#patient').autocomplete({
        // serviceUrl: '/autosuggest/service/url',
        lookup: countriesArray,
        lookupFilter: function(suggestion, originalQuery, queryLowerCase) {
            var re = new RegExp('\\b' + $a.Autocomplete.utils.escapeRegExChars(queryLowerCase), 'gi');
            return re.test(suggestion.value);
        },
        onSelect: function(suggestion) {
            $a('#selction-ajax').html('You selected: ' + suggestion.value + ', ' + suggestion.data);
        },
        onHint: function (hint) {
            $a('#autocomplete-ajax-x').val(hint);
        },
        onInvalidateSelection: function() {
            $a('#selction-ajax').html('You selected: none');
        }
    });   
   
   
});