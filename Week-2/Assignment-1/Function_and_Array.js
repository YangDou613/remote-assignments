function max(numbers) {
	let maxNum;
	for (let i = 0; i < numbers.length; i++) {
		if (!maxNum) {
			maxNum = numbers[i];
		} else if (maxNum < numbers[i]) {
			maxNum = numbers[i];
		}
	}
	return maxNum;
}

function findPosition(numbers, target) {
	for (let i = 0; i < numbers.length; i++) {
		if (numbers[i] === target) {
			return i;
		}
	}
	return -1;
}

console.log(max([1, 2, 4, 5]));
console.log(max([5, 2, 7, 1, 6]));

console.log(findPosition([5, 2, 7, 1, 6], 5));
console.log(findPosition([5, 2, 7, 1, 6], 7));
console.log(findPosition([5, 2, 7, 7, 7, 1, 6], 7));
console.log(findPosition([5, 2, 7, 1, 6], 8));