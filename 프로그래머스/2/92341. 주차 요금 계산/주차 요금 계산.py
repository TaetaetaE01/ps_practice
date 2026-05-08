import math

def solution(fees, records):
    d_t, d_c, u_t, u_c = fees[0], fees[1], fees[2], fees[3]
    d = {}
    
    for re in records:
        record = re.split()
        time, number, signal = record[0], record[1], record[2]
        
        if number not in d:
            d[number] = [0,0,'', 0]
        
        h, m = time.split(':')
        t = int(h)*60 + int(m)
        d[number][2] = signal
        if signal=='IN':
            d[number][0] = t
        else:
            d[number][1] += t - d[number][0]
    
    for key in d:
        value = d[key]
        if value[2]=='IN':
            m = 60*23 + 59
            d[key][1] += m - d[key][0]
            
        
        if value[1]<=d_t:
            d[key][3] = d_c
        else:
            d[key][3] = d_c
            value[1] -= d_t
            tt = math.ceil(value[1] / u_t)
            d[key][3] += u_c*tt
            
    s = sorted(d.keys())
    result = []
    for i in s:
        result.append(d[i][3])
        
    return result