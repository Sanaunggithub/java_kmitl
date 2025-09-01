import matplotlib.pyplot as plt 
 

input_sizes = [100_000, 200_000, 300_000, 400_000, 500_000, 600_000, 700_000, 
800_000, 900_000, 1_000_000] 
 

runtime_A = [982, 2653, 6451, 10349, 19030, 32841, 29313, 45779, 62438, 61877]
runtime_B = [16, 34, 43, 58, 75, 106, 121, 150, 177, 196]
runtime_C = [7, 12, 18, 23, 29, 36, 45, 53, 68, 77]
 
# Plotting 
plt.figure(figsize=(10, 6)) 
plt.plot(input_sizes, runtime_A, marker='o', label='Algorithm A (O(n))') 
plt.plot(input_sizes, runtime_B, marker='s', label='Algorithm B (O(n log n))') 
plt.plot(input_sizes, runtime_C, marker='^', label='Algorithm C (O(n²))') 
 
plt.title('Runtime Comparison of Three Algorithms') 
plt.xlabel('Input Size (n)') 
plt.ylabel('Runtime (ms)') 
plt.grid(True) 
plt.legend() 
plt.tight_layout() 

plt.show() 