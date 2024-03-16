def cal_days(year, month, date):
    days = ((year * 12) + month) * 28 + date
    return days
    
def is_expired(today_days, privacy_days):
    if(today_days >= privacy_days):
        return True
    return False
        

def solution(today, terms, privacies):
    answer = []
    today_days = cal_days(int(today[:4]), int(today[5:7]), int(today[8:]))
    
    terms_dic = {}
    for term in terms:
        terms_dic[term[:1]] = int(term[2:])
    
    for i in range(len(privacies)):
        privacy = privacies[i]
        privacy_Type = privacy[-1:]
        privacy_days = cal_days(int(privacy[:4]), int(privacy[5:7]) + int(terms_dic.get(privacy_Type)), int(privacy[8:10]))

        if(is_expired(today_days, privacy_days)):
            answer.append(i + 1)
    
    return answer