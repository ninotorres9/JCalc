Function assertEqual($exprssion, $answer)
{
    $result = (echo $exprssion | java MainVisit)
    if($result -eq $answer){ 
        "True" 
    }
    else { 
        Write-Host -ForegroundColor Red $exprssion "result: " $result " answer: "  $answer
    }
}

assertEqual "1+2" 3
assertEqual "1*2" 2
assertEqual "1+9*2" 19
assertEqual "(10+12)/2" 11
assertEqual "(1+2)^2+10" 19