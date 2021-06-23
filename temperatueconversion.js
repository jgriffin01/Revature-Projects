function celciusConvert(a) {
    var celcius = ((a-32) * (5/9))
    return celcius
  }
  
  var input = 'Albany|22.2*Caribou|9.5*Columbia|44.6*Denver|29.2*Indianapolis|26.5*Montgomery|46.6*San Diego|57.8*Tulsa|36.4*Tampa|61.3*Billings|24.0'
  
  var hot = []
  var moderate = []
  var cold = []
  
  input = input.split('*')
  for (var  i = 0; i < input.length; i++) {
    var result = input[i].split('|')
    var temp = celciusConvert(result[1])
    var rounded = Math.round(temp * 10)/10
    if (rounded < 20) {
      cold.push(result[0] + '(' + rounded + ')')
    }
    else if (temp < 30) {
      moderate.push(result[0] + '(' + rounded + ')')
    }
    else {
      hot.push(result[0] + '(' + rounded + ')')
    }
  }
  
  console.log('Cold:')
  for (var i = 0; i < cold.length; i++) {
    console.log(cold[i])
  }
  
  console.log('')
  console.log('Moderate:')
  for (var i = 0; i < moderate.length; i++) {
    console.log(moderate[i])
  }
  
  console.log('')
  console.log('Hot:')
  for (var i = 0; i < hot.length; i++) {
    console.log(hot[i])
  }