import numpy as np 
import pandas as pd
from flask import Flask,request,Response
import json



df=pd.read_csv('zomato_clean.csv')

def rec(location , cost , rating , cuisine , df=df.copy()):
    rests_loc = df.loc[df['location'] == location]
    
    rests_cost = rests_loc.loc[rests_loc['cost']<=cost]
    
    rests_rating1 = rests_cost.loc[rests_cost['rate']>=rating]
    
    rests = rests_rating1.copy()

    d={}
    key=0
    s=""
    for i in range(min(len(rests),30)):
        if( cuisine.lower() in rests_rating1.iloc[i,12].lower() ):
            dic={}
            dic['name'] = rests.iloc[i, 3]
            dic['url'] = rests.iloc[i, 1]
            dic['cuisines'] = rests.iloc[i, 12]
            dic['rate'] = rests.iloc[i, 6]
            dic['cost'] = rests.iloc[i, 13]
            dic['rest_type'] = rests.iloc[i, 10]
            s+=str(dic['name'])+"\n"+str(dic['url'])+"\n"+str(dic['cuisines'])+"\n"+str(dic['rate'])+"\n"+str(dic['cost'])+"\n"+str(dic['rest_type'])+"\n"
                  
    return s



app=Flask(__name__)
app.config['ENV'] = 'development'
app.config['DEBUG'] = True
app.config['TESTING'] = True



@app.route('/api/recommend',methods=['GET'])

def recommend():
    location = request.args.get('location')
    cost = request.args.get('cost')
    rating = request.args.get('rating')
    cuisine = request.args.get('cuisine')
    
    res = rec( str(location), int(cost), float(rating), str(cuisine) )

    return Response(response=res, status=200, mimetype="application/json")
    




if(__name__=="__main__"):
    app.run(host="0.0.0.0",port=5000)