function countAandB(input) {
	var a = 0;
	var b = 0;
	for (var ele of input) {
		if (ele == 'a') {
			a += 1;
		} else if (ele == 'b') {
			b += 1;
		}
	}
	var total = a + b;
	if (total == 0) {
		return "0";
	}
	return total + " (" + a + " \'a\' letters and " + b + " \'b\' letter)";
}

function toNumber(input) {
	var a = 1;
	var b = 2;
	var c = 3;
	var d = 4;
	var e = 5;
	let ans = [];
	for (var ele of input) {
		if (ele == 'a') {
			ans.push(a);
		} else if (ele == 'b') {
			ans.push(b);
		} else if (ele == 'c') {
			ans.push(c);
		} else if (ele == 'd') {
			ans.push(d);
		} else if (ele == 'e') {
			ans.push(e);
		}
	}
	return ans;
}

let input1 = ['a', 'b', 'c', 'a', 'c', 'a', 'c'];
console.log(countAandB(input1));
console.log(toNumber(input1));

let input2 = ['e', 'd', 'c', 'd', 'e'];
console.log(countAandB(input2));
console.log(toNumber(input2));